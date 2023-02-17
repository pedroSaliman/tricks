package com.tests.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.utils.fixtures.Job;
import uk.co.jemos.podam.api.ClassInfoStrategy;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.lang.reflect.Type;
import java.util.List;

public class RunWithJob {
    public static void main(String[] args) {

        PodamFactory fac=new PodamFactoryImpl();
        Job j= fac.manufacturePojo(Job.class);
        System.out.println(j);

        Fixture.of(Job.class).addTemplate("vaild job",new Rule(){

            {
                add("job",random(  j.getJob()));
                add("username",random(j.getUsername()));

            }
        });
      List<Job> vaild=  Fixture.from(Job.class).gimme(20,"vaild job");
      vaild.forEach(System.out::println);
    }
}
