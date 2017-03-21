package com.ssm.login.entity;

/**
 * 操作实体类 t_operation
 */
public class OperationEntity {
    /**
     * id
     */
    private Integer operationEntityId;
    /**
     * 操作名称
     */
    private String operation;
    /**
     * 对应方法
     */
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getOperationEntityId() {
        return operationEntityId;
    }

    public void setOperationEntityId(Integer operationEntityId) {
        this.operationEntityId = operationEntityId;
    }
}
