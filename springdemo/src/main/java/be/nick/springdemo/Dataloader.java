package be.nick.springdemo;



import be.nick.springdemo.model.Tip;
import be.nick.springdemo.model.User;
import be.nick.springdemo.repository.TipRepository;
import be.nick.springdemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    private UserRepository userRepository;
    private TipRepository tipRepository;

    private static final Logger LOG = LoggerFactory.getLogger(Dataloader.class);

    @Autowired
    public Dataloader(UserRepository userRepository, TipRepository tipRepository) {
        this.userRepository = userRepository;
        this.tipRepository = tipRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        addUsers();
        addTips();
        showDummyContent();
    }

    private void addUsers(){
        userRepository.save(new User("David", "Opstras", "DevOps", "secret", "devops.test@email.com"));
        userRepository.save(new User("Jan", "Peeters", "Jakke", "1234", "jan.test@email.com"));
    }

    private void addTips(){
        tipRepository.save(new Tip("Consistency is the trick of learning a new programming language", userRepository.getOne(1l)));
        tipRepository.save(new Tip("Set reachable short term goals", userRepository.getOne(1l)));
        tipRepository.save(new Tip("Talk to as many experts as possible", userRepository.getOne(2L)));
    }

    private void showDummyContent(){

        LOG.info("Users found with findAll():");
        LOG.info("-------------------------------");
        for (User user : userRepository.findAll()) {
            LOG.info(user.toString());
        }
        LOG.info("");

        LOG.info("User stories found with findAll():");
        LOG.info("-------------------------------");
        for (Tip tip : tipRepository.findAll()) {
            LOG.info(tip.toString());
        }
        LOG.info("");
    }
}
