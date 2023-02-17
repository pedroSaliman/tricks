package com.utils.templatesfix;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class Job implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(com.utils.fixturesfactory.Job.class).addTemplate("valid",new Rule(){

            {
                add("job",random("test","developer","devops"));
                add("username",random("mahmoud","mohamed","walled"));

            }
        });


    }
}
