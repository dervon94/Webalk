package hu.iit.uni.miskolc.web.config;

import hu.iit.uni.miskolc.RegistryController;
import hu.iit.uni.miskolc.dao.RunnerDAO;
import hu.iit.uni.miskolc.dao.RunnerMemoryDAO;
import hu.iit.uni.miskolc.service.RegistryManagerService;
import hu.iit.uni.miskolc.service.RegistryManagerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig {
    @Bean(value = "RunnerDAO")
    public RunnerDAO initRunnerDAO(){
        return new RunnerMemoryDAO();
    }

    @Bean(value = "RegistryManager")
    public RegistryManagerService initRegistryManagerService(){
        return new RegistryManagerServiceImpl(initRunnerDAO());
    }

    @Bean(value = "RegistryController")
    public RegistryController initRegistryController(){
        return new RegistryController(initRegistryManagerService());
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver result = new InternalResourceViewResolver();
        result.setViewClass(JstlView.class);
        result.setPrefix("/WEB-INF/views");
        result.setSuffix(".html");
        return result;
    }

}
