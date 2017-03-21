package com.ssm.login.entity;

import java.util.List;

/**
 * 权限实体类 t_permission
 */
public class PermissionEntity {
    /**
     * id
     */
    private Integer  permissionEntityId;
    /**
     * 权限
     */
    private String permission;

    private List<OperationEntity> operationEntities;

    public List<OperationEntity> getOperationEntities() {
        return operationEntities;
    }

    public void setOperationEntities(List<OperationEntity> operationEntities) {
        this.operationEntities = operationEntities;
    }

    public Integer getPermissionEntityId() {
        return permissionEntityId;
    }

    public void setPermissionEntityId(Integer permissionEntityId) {
        this.permissionEntityId = permissionEntityId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
