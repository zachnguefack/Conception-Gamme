package org.sid.offregame;

import org.sid.offregame.dao.SubOtherTaskRepository;
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
    @Autowired
    private SubOtherTaskRepository subOtherTaskRepository;

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



            /*offreGameService.saveTaskTimeParameter(true,"Auto Controle",8,9,72,0.15,"d048bedb-d593-46e9-b8c4-0c04a65cd17a");
            offreGameService.saveTaskTimeParameter(true,"Manipulation",8,6,48,0.10,"d048bedb-d593-46e9-b8c4-0c04a65cd17a");
            offreGameService.saveTaskTimeParameter(true,"Nettoyage Posage,separation piece",8,3,24,0.05,"d048bedb-d593-46e9-b8c4-0c04a65cd17a");
            offreGameService.saveTaskTimeParameter(true,"Affutage burin",8,2.5,20,0.042,"d048bedb-d593-46e9-b8c4-0c04a65cd17a");

            offreGameService.saveTaskPrecisionParameter(true,480,1731,1139,3.2,
                    3.01,0.84,0.85,100,6508,"d048bedb-d593-46e9-b8c4-0c04a65cd17a");
            */

           // offreGameService.findByTask("categorie test");
           // offreGameService.saveSubOtherTask();

           /* Task task = taskRepository.findById("cb6b5fd5-8b55-490e-b5bf-cf1d82e637d9").orElse(null);
            List<SubOtherTask> subOtherTasks = new ArrayList<>();
            SubOtherTask netttoyage = subOtherTaskRepository.findByName("Nettoyage");
            SubOtherTask evaluationQualite = subOtherTaskRepository.findByName("Evaluation Qualite");
            subOtherTasks.add(netttoyage);
            subOtherTasks.add(evaluationQualite);
            task.setSubOtherTasks(subOtherTasks);
            taskRepository.save(task);
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
