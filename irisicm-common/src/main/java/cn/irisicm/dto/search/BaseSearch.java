package cn.irisicm.dto.search;

import cn.irisicm.dto.result.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author hmhu6
 */
@ApiModel(value = "BaseSearch", description = "基础分页查询对象")
public class BaseSearch implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2592573291048432475L;

    public static final String ORDER_TYPE_ASC = "ASC";

    public static final String ORDER_TYPE_DESC = "DESC";

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer currentPageNo;

    /**
     * 页大小
     */
    @ApiModelProperty(value = "分页大小")
    private Integer pageSize;

    /**
     * 分页页数
     */
    @ApiModelProperty(value = "分页页数")
    private Integer pageNo;

    /**
     * 排序类型 ASC/DESC
     */
    @ApiModelProperty(value = "排序类型 ASC/DESC")
    private String orderType;

    /**
     * 排序属性名称
     */
    @ApiModelProperty(value = "排序属性名称")
    private String orderName;

    /**
     * <p>
     * <code>validate</code>验证参数合法性
     * </p>
     *
     * @param requirePage 是否需要分页
     *                    <p>
     *                    true:需要分页,分页参数为必填
     *                    <p>
     *                    false不需要分页，不进行验证
     *                    <p>
     *                    null:若参数有时，进行范围验证
     * @return 是否需要分页
     */
    public boolean validate(Boolean requirePage) {
        if (null != requirePage && requirePage) {
            if (null == currentPageNo || 0 >= currentPageNo || null == pageSize
                    || pageSize > PageInfo.DEFAULT_MAX_PAGE_SIZE) {
                return false;
            }
        }
        if (StringUtils.isNotBlank(orderType) && !ORDER_TYPE_ASC.equalsIgnoreCase(orderType)
                && !ORDER_TYPE_DESC.equalsIgnoreCase(orderType)) {
            return false;
        }
        return true;
    }

    /**
     * <p>
     * <code>validate</code>默认验证分页信息
     * </p>
     *
     * @return 验证结果
     */
    public boolean validate() {
        return this.validate(true);
    }

    /**
     * 获取分页开始行
     */
    public int getStartPage() {
        return (this.currentPageNo - 1) * this.pageSize;
    }

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
