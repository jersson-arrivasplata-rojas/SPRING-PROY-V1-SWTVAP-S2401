package com.jersson.arrivasplata.swtvap.api.sso.business.implementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.jersson.arrivasplata.swtvap.api.sso.business.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {

    private AmazonS3 s3Client;

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${s3.bucket}")
    private String bucketName;

    @Value("${s3.endpoint}")
    private String bucketEndpoint;

    public StorageServiceImpl() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(bucketEndpoint, region))
                .build();
    }

    public void uploadFile(String keyName, MultipartFile uploadFilePath) {
        try {
            // Create a temporary file and copy the multipart file content into it
            File file = File.createTempFile("temp", null);
            uploadFilePath.transferTo(file);

            // Upload the file to S3
            s3Client.putObject(new PutObjectRequest(bucketName, keyName, file));

            // Delete the temporary file
            file.delete();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

    }

    public void updateFile(String keyName, MultipartFile newFile) {
        // To update a file, we simply upload a new file with the same key
        uploadFile(keyName, newFile);
    }

    public void removeFile(String keyName) {
        this.s3Client.deleteObject(new DeleteObjectRequest(bucketName, keyName));
    }

    public List<String> listFiles() {
        List<String> keys = new ArrayList<>();
        ObjectListing objects = s3Client.listObjects(bucketName);
        for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
            keys.add(objectSummary.getKey());
        }
        return keys;
    }
    // Métodos adicionales para descargar y eliminar archivos, etc.
}
