/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.dataformat.soap.springboot;

import java.util.HashMap;
import java.util.Map;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.dataformat.soap.SoapJaxbDataFormat;
import org.apache.camel.util.IntrospectionSupport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Configuration
@EnableConfigurationProperties(SoapJaxbDataFormatConfiguration.class)
public class SoapJaxbDataFormatAutoConfiguration {

    @Bean(name = "soapjaxb-dataformat")
    @ConditionalOnClass(CamelContext.class)
    @ConditionalOnMissingBean(SoapJaxbDataFormat.class)
    public SoapJaxbDataFormat configureSoapJaxbDataFormat(
            CamelContext camelContext,
            SoapJaxbDataFormatConfiguration configuration) throws Exception {
        SoapJaxbDataFormat dataformat = new SoapJaxbDataFormat();
        if (dataformat instanceof CamelContextAware) {
            ((CamelContextAware) dataformat).setCamelContext(camelContext);
        }
        Map<String, Object> parameters = new HashMap<>();
        IntrospectionSupport.getProperties(configuration, parameters, null,
                false);
        IntrospectionSupport.setProperties(camelContext,
                camelContext.getTypeConverter(), dataformat, parameters);
        return dataformat;
    }
}