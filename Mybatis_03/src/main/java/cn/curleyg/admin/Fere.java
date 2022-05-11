package cn.curleyg.admin;

public class Fere {
    private Integer id;

    private String name;

    private Integer userid;

    public Fere(Integer id, String name, Integer userid) {
        this.id = id;
        this.name = name;
        this.userid = userid;
    }

    public Fere() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}