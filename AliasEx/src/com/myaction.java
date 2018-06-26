package com;

import com.opensymphony.xwork2.ActionSupport;

public class myaction extends ActionSupport
{
    private String studentid;
    private String studentname;
    private double mks1, mks2, mks3, answer;

    public double getMks1()
    {
          return mks1;
    }

    public double getMks2()
    {
          return mks2;
    }
    public double getMks3()
    {
          return mks3;
    }
    public void setMks1 (double mks1)
    {
        this.mks1 = mks1;
    }
    public void setMks2 (double mks2)
    {
        this.mks2 = mks2;
    }
    public void setMks3 (double mks3)
    {
        this.mks3 = mks3;
    }
    public String getStudentid()
    {
        return studentid;
    }
    public void setStudentid (String studentid)
    {
       this.studentid = studentid;
    }
    public String getStudentname()
   {
       return studentname;
   }
   public void setStudentname (String studentname)
   {
       this.studentname = studentname;
   }
   public double getAnswer()
   {
       return answer;
   }
   public void setAnswer (double answer)
   {
       this.answer = answer;
   }
       public String execute()
   {
      answer = (mks1 + mks2 + mks3) / 3;
      return "success";
   }
}