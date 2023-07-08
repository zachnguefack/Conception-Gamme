package org.sid.offregame;

import org.sid.offregame.dao.TaskCategoryRepository;
import org.sid.offregame.dao.TaskRepository;
import org.sid.offregame.services.OffreGameService;
import org.sid.offregame.services.OffreGameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sid.offregame.entities.*;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class OffreGameApplication {

    @Autowired
    private TaskCategoryRepository taskCategoryRepository;
    @Autowired
    private TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(OffreGameApplication.class, args);
    }

    @Bean
	CommandLineRunner commandLineRunner(OffreGameService offreGameService){

		return args -> {

		/*Stream.of("TourneurAvant", "TourneurArriere", "EbaucheAvant","EbaucheArriere","EbauchePelle",
                "Coupe","CoupeEnRetrait","BurinDeForme","BurinPCD").forEach(name->{

			});*/

           /* offreGameService.saveParametreDecolletage("FraiseParGeneration",false,2.0000,530,4L);
            offreGameService.saveParametreDecolletage("FraiseDentParDent",false,1.0000,48,4L);
            offreGameService.saveParametreDecolletage("FraiseACentre",true,0.3333,48,4L);
            offreGameService.saveParametreDecolletage("FraiseGloorDenture",false,2.0000,300,4L);

            */

            /*offreGameService.saveSubOtherTask(true,20,"Nettoyage Piece",0.42,8,"6a1dd975-b63a-473d-8f22-1151bb1c9be0");
            offreGameService.saveSubOtherTask(true,21,"Evaluation Qualite",1,8,"6a1dd975-b63a-473d-8f22-1151bb1c9be0");
            */

            /*offreGameService.saveTaskTimeParameter(true,"Auto Controle",8,12,96,0.2,"cb6b5fd5-8b55-490e-b5bf-cf1d82e637d9");
            offreGameService.saveTaskTimeParameter(true,"Manipulation",8,4,32,0.067,"cb6b5fd5-8b55-490e-b5bf-cf1d82e637d9");
            offreGameService.saveTaskTimeParameter(true,"Nettoyage Place De Travail",8,3,24,0.05,"cb6b5fd5-8b55-490e-b5bf-cf1d82e637d9");
            offreGameService.saveTaskTimeParameter(true,"Nettoyage Posage",8,3,24,0.05,"cb6b5fd5-8b55-490e-b5bf-cf1d82e637d9");

            offreGameService.saveTaskPrecisionParameter(true,480,6,4,983.7,
                    80.37,0.84,0.85,63,84,"cb6b5fd5-8b55-490e-b5bf-cf1d82e637d9");

            offreGameService.saveSubOtherTask(true,20,"Nettoyage Piece",0.5,8,"cb6b5fd5-8b55-490e-b5bf-cf1d82e637d9");
            offreGameService.saveSubOtherTask(true,21,"Evaluation Qualite",0.42,8,"cb6b5fd5-8b55-490e-b5bf-cf1d82e637d9");
*/
		};

    }

   /* @Bean
    CommandLineRunner commandLineRunner(OffreGameService offreGameService) {

        return args -> {

         List<TaskCategory> taskCategories = offreGameService.listCategory();
            int count = 0;

            List<String> taches = Arrays.asList("RepriseCN", "RectifQuill(TrouFini)", "Roue_A_Bras", "Colima_Meule", "Contre-Perç_Sdt", "TaskMoulur-TV-test",
                    "TaskEnchainageTest", "TaskRoulageTest", "TaskTerminaison HorlogèreTest", "TaskBouclardTest", "TaskOP-ManuelleTest", "TaskCerclage 2 Test", "TaskMoulureTest",
                    "TaskBrochageTest", "TaskAssemblageTest", "TaskTraitement de surface Test", "TaskPolissageTest", "TaskTerminaison MauelleTest");

            for (TaskCategory taskCategory : taskCategories) {
                offreGameService.saveOtherTask(taches.get(count++), false, 10, 25, 0.5, 32, taskCategory.getId());
            }

            offreGameService.saveOtherTask("Task2", false, 20, 25, 0.5, 32, 1L);
            offreGameService.saveOtherTask("Task3", false, 20, 25, 0.5, 32, 1L);
            offreGameService.saveOtherTask("Task4", false, 20, 25, 0.5, 32, 1L);
            offreGameService.saveOtherTask("Task2", false, 20, 25, 0.5, 32, 2L);
            offreGameService.saveOtherTask("Task3", false, 20, 25, 0.5, 32, 2L);
            offreGameService.saveOtherTask("Task4", false, 20, 25, 0.5, 32, 2L);

            TaskCategory taskCategory = taskCategoryRepository.findByCategoryName("Decoupage");

            System.out.println(taskCategory.getCategoryName());

            offreGameService.saveTaskTimeParameter(true,"Auto Controle",8,10,80,0.167,"08cc366a-0ec1-481a-b764-ac5ab7b3644a");
            offreGameService.saveTaskTimeParameter(true,"Manipulation",8,5,40,0.083,"08cc366a-0ec1-481a-b764-ac5ab7b3644a");
            offreGameService.saveTaskTimeParameter(true,"Nettoyage Bande & Surveillance",8,5,40,0.083,"08cc366a-0ec1-481a-b764-ac5ab7b3644a");
            offreGameService.saveTaskTimeParameter(true,"Affutage Lege",8,6,48,0.01,"08cc366a-0ec1-481a-b764-ac5ab7b3644a");


            offreGameService.saveTaskPrecisionParameter(true,480,7200,4080,0.9,0.29,0.84,
                    0.85,50000,23305,"08cc366a-0ec1-481a-b764-ac5ab7b3644a");
            ;
            offreGameService.saveSubOtherTask(true,offreGameService.getTaskById("08cc366a-0ec1-481a-b764-ac5ab7b3644a").getNumero() + 1,"Nettoyage Piece",0.5,0.0,"08cc366a-0ec1-481a-b764-ac5ab7b3644a");
            offreGameService.saveSubOtherTask(true,offreGameService.getTaskById("08cc366a-0ec1-481a-b764-ac5ab7b3644a").getNumero() + 2,"EValuation Qualite",0.42,0.0,"08cc366a-0ec1-481a-b764-ac5ab7b3644a");




        };

    }
*/
}
