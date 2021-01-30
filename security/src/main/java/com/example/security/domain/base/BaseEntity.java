package com.example.security.domain.base;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-29 10:51
 */
@MappedSuperclass
public abstract class BaseEntity extends BaseId {
    public static final String LIFE_CYCLE = "life_cycle";
    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Long createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    private Long updateTime;

    /**
     * 实体的生命周期
     */
    @ApiModelProperty(hidden = true)
    @Enumerated(EnumType.STRING)
    private LifeCycle lifeCycle;

    enum LifeCycle {
        /**
         * 实体状态
         */
        RUNNING("活动状态"),
        PAUSED("暂停状态"),
        STOPPED("停止状态"),
        KILLED("非活动状态");

        /**
         * 中文解释
         */
        private final String chinese;

        LifeCycle(String chinese) {
            this.chinese = chinese;
        }

        public String getChinese() {
            return chinese;
        }
    }

    public BaseEntity() {
    }

    @PrePersist
    void prePersist() {
        long time = System.currentTimeMillis();
        setCreateTime(time);
        setUpdateTime(time);
        initLifeCycle();
    }

    private void initLifeCycle() {
        setLifeCycle(LifeCycle.RUNNING);
    }

    @PreUpdate
    void preUpdate() {
        this.updateTime = System.currentTimeMillis();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public LifeCycle getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }
}
