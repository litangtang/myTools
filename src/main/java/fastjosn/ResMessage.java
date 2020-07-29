package fastjosn;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResMessage implements Serializable {

    private String rpid;

    private Map<String, Object> resMap = new HashMap<String, Object>();


    public void put(String key, Object value) {
        this.resMap.put(key, value);
    }

    public void put(Map<String, Object> data) {
        this.resMap.putAll(data);
    }

    public String getRpid() {
        return rpid;
    }

    public void setRpid(String rpid) {
        this.rpid = rpid;
    }

    public Map<String, Object> getResMap() {
        return resMap;
    }

    public void setResMap(Map<String, Object> resMap) {
        this.resMap = resMap;
    }
}
