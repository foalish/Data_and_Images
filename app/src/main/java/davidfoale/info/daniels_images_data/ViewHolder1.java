package davidfoale.info.daniels_images_data;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;



public class ViewHolder1 extends RecyclerView.ViewHolder {

    private TextView degree, salary, qualifications, job_desc,job_title, job_tips;

    public ViewHolder1(View v) {
        super(v);
        job_tips       = (TextView) v.findViewById(R.id.job_tips);
        salary         = (TextView) v.findViewById(R.id.salary);
        degree         = (TextView) v.findViewById(R.id.degree);
        qualifications = (TextView) v.findViewById(R.id.qualifications);
        job_desc       = (TextView) v.findViewById(R.id.job_desc);
        job_title      = (TextView) v.findViewById(R.id.job_title);
    }

    public TextView getJob_tips()              { return job_tips;  }
    public void setJob_tips(TextView job_tips) { this.job_tips = job_tips;}

    public TextView getSalary()                { return salary;    }
    public void setSalary(TextView salary)     { this.salary = salary; }

    public TextView getDegree()                { return degree;    }
    public void setDegree(TextView degree)     { this.degree = degree; }

    public TextView getQualifications()        { return qualifications; }
    public void setQualifications(TextView qualifications)
                                               { this.qualifications = qualifications; }

    public TextView getJob_desc()              { return job_desc;   }
    public void setJob_desc(TextView job_desc) {
        this.job_desc = job_desc;
    }

    public TextView getJob_title()               { return job_title;  }
    public void setJob_title(TextView job_title) { this.job_title = job_title; }


}