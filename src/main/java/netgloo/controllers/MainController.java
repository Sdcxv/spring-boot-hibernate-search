package netgloo.controllers;

import netgloo.models.User;
import netgloo.search.UserSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * MainController class
 * 
 * @author netgloo
 */
@Controller
public class MainController {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------

  // Inject the UserSearch object
  @Autowired
  private UserSearch userSearch;


  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Index main page.
   */
  @RequestMapping("/")
  public String index() {
    return "index";
  }


  /**
   * Show search results for the given query.
   *
   * @param q The search query.
   */
  @RequestMapping("/search")
  public String search(@RequestParam("q") String q, Model model) {
    List<User> searchResults = null;
    try {
      searchResults = userSearch.search(q);
    }
    catch (Exception ex) {
      // here you should handle unexpected errors
      // ...
      // throw ex;
    }
    model.addAttribute("searchResults", searchResults);
    return "search";
  }


} // class MainController
