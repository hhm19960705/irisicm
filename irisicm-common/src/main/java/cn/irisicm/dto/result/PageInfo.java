package cn.irisicm.dto.result;

import cn.irisicm.util.CommonUtils;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hmhu6
 */
@Data
public class PageInfo<T> implements Serializable {

    /**
     * 默认页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 100;

    /**
     * 默认最大页大小
     */
    public static final int DEFAULT_MAX_PAGE_SIZE = 200;
    
    private JSONArray records;
    private long total;
    private long pageSize;
    private long current;

    public void setPageInfo(IPage<T> page) {
        this.total = page.getTotal();
        this.pageSize = page.getSize();
        this.current = page.getCurrent();
        this.records = CommonUtils.listToJsonArray(page.getRecords());
    }
}
