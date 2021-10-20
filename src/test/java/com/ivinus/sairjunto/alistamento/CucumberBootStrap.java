package com.ivinus.sairjunto.alistamento;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@CucumberContextConfiguration
@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberBootStrap {
    @Before
    public void before() {
        log.info(">>> inclusão dos dados de teste");
        //Agendamento agendamento = AgendamentoFactory.agendamentoQualquerParaPalavras(TagFactory.tagsParaCerveja());
        //agendamentoRepository.save(agendamento);
    }

    @After
    public void cleanUp() {
        log.info(">>> limpeza da base de dados");
        //tagRepository.deleteAll();
        //agendamentoRepository.deleteAll();
    }

    //Method annotated with @AfterStep executes after every step
    @AfterStep
    public void afterStep() {
        log.info(">>> AfterStep!");
        //placeholder for after step logic
    }

    //Method annotated with @BeforeStep executes before every step
    @BeforeStep
    public void beforeStep() {
        log.info(">>> BeforeStep!");
        //placeholder for before step logic
    }
}
