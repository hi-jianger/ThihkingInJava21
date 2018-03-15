package com.package2124;

/**
 * 操作对象时吐司
 *   吐司的相关属性
 *   吐司的状态之间的变化
 * @author jianger
 * @Date 2018/3/4 上午11:12
 **/
public class Toast {
    /**
     * 吐司的三种状态
     */
    public enum Status{
        DRY,BUTTERED,JAMMED;
    }

    /**
     * 默认是干的状态
     */
    private Status status=Status.DRY;

    /**
     * 给吐司标号
     */
    private final Integer intId;

    public Toast(Integer intId) {
        this.intId = intId;
    }

    /**
     * 将吐司由干的状态变成抹黄油的状态
     */
    public void butter(){
        status=Status.BUTTERED;
    }

    /**
     * 将吐司由黄油变成果酱
     */
    public void jam(){
        status=Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getIntId() {
        return intId;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", intId=" + intId +
                '}';
    }
}
