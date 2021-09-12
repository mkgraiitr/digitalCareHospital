package com.evooq.digitalCareHospital;

import com.evooq.digitalCareHospital.handler.CommandHandler;
import com.evooq.digitalCareHospital.handler.Handler;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalCareHospitalApplication {

    public static void main(String[] args) {
        Handler handler = new CommandHandler();
        handler.handle();
    }

}
