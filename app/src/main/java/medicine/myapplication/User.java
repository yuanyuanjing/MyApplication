package medicine.myapplication;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2017/6/6.
 */
@Table(name="User")

public class User {

    @Column(name = "id",isId = true)
    private int id;
    @Column(name="NAME",property = "NOT NULL")//NAME 字段非空
    private String name;
    @Column(name="AGE",property = "NOT NULL")
    private int age;
    public User(){

    }

    public User(String name, int age){
        this.name = name;
        this.age = age;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{"+name+","+age+"}";
    }
}
