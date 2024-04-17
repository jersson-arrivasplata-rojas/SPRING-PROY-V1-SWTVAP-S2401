package com.jersson.arrivasplata.swtvap.api.setting.business.service;

import com.jersson.arrivasplata.swtvap.api.setting.model.Parameter;

import java.util.List;

public interface ParameterService {
    List<Parameter> getAllParameters();

    Parameter getParameterById(Long id);

    Parameter createParameter(Parameter parameter);

    Parameter updateParameter(Long id, Parameter updatedParameter);

    void deleteParameterById(Long id);
}
