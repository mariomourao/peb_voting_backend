package pt.scocs.pebvotebackend.controller;

import pt.scocs.pebvotebackend.domain.VoteRepository;
import pt.scocs.pebvotebackend.domain.Vote
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class NoteController {

    @Autowired
    VoteRepository voteRepository;

    @GetMapping("/vote")
    public List<Vote> getAllVotes(HttpServletRequest request) {
     System.out.println("************** Remote Address: " + request.getRemoteAddr());
     return voteRepository.findByIpAndJuri(request.getRemoteAddr(),false);

    }

    @GetMapping("/juri")
    public List<Vote> getAllVotesJuri(HttpServletRequest request) {
     System.out.println("************** Remote Address: " + request.getRemoteAddr());
     return voteRepository.findByIpAndJuri(request.getRemoteAddr(),true);

    }


    @GetMapping("/ip")
    public String myIp(HttpServletRequest request) {
     return request.getRemoteAddr();

    }

    // Create a new Note
    @PostMapping("/vote")
    public Vote createNote(HttpServletRequest request,@Valid @RequestBody Vote vote) {
        System.out.println("************** Remote Address: " + request.getRemoteAddr());
        vote.ip = request.getRemoteAddr()
        return voteRepository.save(vote);
    }

}


