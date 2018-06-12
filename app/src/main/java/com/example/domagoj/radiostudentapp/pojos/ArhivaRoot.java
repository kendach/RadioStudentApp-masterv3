
package com.example.domagoj.radiostudentapp.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
                                                        //plain old java object POJO
public class ArhivaRoot {                       //Ova klasa objasnjava GSONu kako je json strukturiran, s time da su dodane anotacije za json

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("sql")
    @Expose
    private String sql;
    @SerializedName("rows")
    @Expose
    private List<ArhivaRow> rows = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<ArhivaRow> getRows() {
        return rows;
    }

    public void setRows(List<ArhivaRow> rows) {
        this.rows = rows;
    }

}
