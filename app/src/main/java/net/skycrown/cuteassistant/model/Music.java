package net.skycrown.cuteassistant.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by skycrown on 2018/6/17.
 */

@Entity
public class Music {
    @Id(autoincrement = true)
    Long id;
    String name;

    @Generated(hash = 2016062716)
    public Music(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1263212761)
    public Music() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
