package com.jersson.arrivasplata.swtvap.api.sso.business.implementation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.jersson.arrivasplata.swtvap.api.sso.business.service.StorageService;
import com.jersson.arrivasplata.swtvap.api.sso.config.SOSConfig;

@Service
public class StorageServiceImpl implements StorageService {

    private AmazonS3 s3Client;

    private SOSConfig config;

    @Autowired
    public StorageServiceImpl(SOSConfig config) {
        this.config = config;

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(config.getAccessKey(), config.getSecretKey());
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(config.getBucketEndpoint(), config.getRegion()))
                .build();
    }

    public void uploadFile(String keyName, String folderName, MultipartFile uploadFilePath) {
        File file = null;
        String fullKeyName = folderName + "/" + keyName;
        try {
            file = File.createTempFile("temp", null);
            uploadFilePath.transferTo(file);

            // Crear una solicitud de put con la configuración de ACL pública
            PutObjectRequest putObjectRequest = new PutObjectRequest(config.getBucketName(), fullKeyName, file)
                    .withCannedAcl(CannedAccessControlList.PublicRead);

            s3Client.putObject(putObjectRequest);
            file.delete();
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        } finally {
            // Ensure temporary file is deleted if an exception occurs
            if (file != null) {
                file.deleteOnExit();
            }
        }
    }

    public void updateFile(String keyName, String folderName, MultipartFile newFile) {
        // To update a file, we simply upload a new file with the same key
        uploadFile(keyName, folderName, newFile);
    }

    public void removeFile(String keyName, String folderName) {
        String fullKeyName = folderName + "/" + keyName;
        s3Client.deleteObject(new DeleteObjectRequest(config.getBucketName(), fullKeyName));
    }

    public List<String> listFiles(String folderName) {
        ListObjectsV2Request req = new ListObjectsV2Request()
        .withBucketName(config.getBucketName())
        .withPrefix(folderName + "/")
        .withDelimiter("/");

    
        ListObjectsV2Result result = s3Client.listObjectsV2(req);
    
        return result.getObjectSummaries().stream()
            .map(S3ObjectSummary::getKey)
            .collect(Collectors.toList());
    }
    
    public void downloadFile(String keyName, String folderName, String localFilePath) {
        String fullKeyName = folderName + "/" + keyName;
        try {
            // Descargar el objeto desde Amazon S3
            S3Object object = s3Client.getObject(config.getBucketName(), fullKeyName);
            S3ObjectInputStream inputStream = object.getObjectContent();

            // Escribir el contenido del objeto en un archivo local
            try (OutputStream outputStream = new FileOutputStream(localFilePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } finally {
                inputStream.close();
            }
            
            System.out.println("Archivo descargado con éxito a: " + localFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to download file", e);
        }
    }
}
