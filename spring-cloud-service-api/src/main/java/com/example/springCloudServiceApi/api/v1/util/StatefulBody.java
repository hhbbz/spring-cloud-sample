/*
 * Copyright © 2016 Minlia (http://oss.minlia.com/license/framework/2016)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.springCloudServiceApi.api.v1.util;

import com.example.springCloudServiceApi.api.v1.util.RequestIdGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulBody<T> implements Body {

    public static final String SUCCESS_MESSAGE = "OK";
    public static final String FAILURE_MESSAGE = "Failure";
    public static final String UNKNOWN_MESSAGE = "Unknown";

    public static final Integer SUCCESS = 200;
    public static final Integer FAILURE = 500;
    public static final Integer UNKNOWN = -1;




    /**
     * 当前操作时间
     */
    @JsonProperty
    protected Date timestamp;

    @JsonProperty
    protected String requestId= RequestIdGenerator.generateRequestId();

    /**
     * 业务操作完成后的返回代码
     */
    @JsonProperty
    protected Integer code;

    /**
     * 用于兼容http状态码, 一般在业务上不使用
     */
    @JsonProperty
    protected Integer status;

    /**
     * 业务操作完成后的返回信息
     */
    @JsonProperty
    protected String message;
    /**
     * 携带的负载返回对象
     */
    @JsonProperty
    protected T payload;

    public StatefulBody() {
        this.timestamp = new Date();
        this.code = UNKNOWN;
        this.message = UNKNOWN_MESSAGE;
        this.status = UNKNOWN;
        this.payload=null;
    }


    public StatefulBody(Integer code,Integer status,String message) {
        this();
        this.timestamp = new Date();
        this.code = code;
        this.status = status;
        this.message = message;
        this.payload=null;
    }


    /**
     * added by qianyi on 2017/4/18.
     * @param code
     * @param status
     * @param message
     * @param payload
     */
    public StatefulBody(Integer code,Integer status,String message,T payload) {
        this();
        this.timestamp = new Date();
        this.code = code;
        this.status = status;
        this.message = message;
        this.payload = payload;
    }


    public Date getTimestamp() {
        return timestamp;
    }

//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }




    @Override
    public String toString() {
       return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this,o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
