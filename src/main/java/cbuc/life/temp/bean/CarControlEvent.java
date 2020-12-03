package cbuc.life.temp.bean;

import java.util.Date;

public class CarControlEvent {
    private Integer id;

    private Integer xqxxbz;

    private String carOwner;

    private String company;

    private String address;

    private String carNumber;

    private String phoneNumber;

    private String controlType;

    private String controlStatus;

    private String featureId;

    private String featureDbId;

    private String featureDbName;

    private String taskId;

    private String remark;

    private Date gmtCreate;

    private Date gmtUpdate;

    private Integer operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXqxxbz() {
        return xqxxbz;
    }

    public void setXqxxbz(Integer xqxxbz) {
        this.xqxxbz = xqxxbz;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner == null ? null : carOwner.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType == null ? null : controlType.trim();
    }

    public String getControlStatus() {
        return controlStatus;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus == null ? null : controlStatus.trim();
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId == null ? null : featureId.trim();
    }

    public String getFeatureDbId() {
        return featureDbId;
    }

    public void setFeatureDbId(String featureDbId) {
        this.featureDbId = featureDbId == null ? null : featureDbId.trim();
    }

    public String getFeatureDbName() {
        return featureDbName;
    }

    public void setFeatureDbName(String featureDbName) {
        this.featureDbName = featureDbName == null ? null : featureDbName.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }
}