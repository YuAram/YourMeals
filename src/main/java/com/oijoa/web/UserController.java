package com.oijoa.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.oijoa.domain.Follow;
import com.oijoa.domain.Recipe;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("loginUser")
public class UserController {

  @Autowired UserService userService;
  @Autowired RecipeService recipeService;
  @Autowired FollowService followService;

  @GetMapping("form")
  public void form() {
  }

  @PostMapping("add")
  public String add(String name, String nick, String email, String password) throws Exception {

    User user = new User();
    user.setName(name);
    user.setNick(nick);
    user.setEmail(email);
    user.setPassword(password);
    user.setPhoto("edda442c-5a56-4427-8c5e-5b052ca055ef");

    userService.add(user);
    return "redirect:../index";
  }

  @GetMapping("delete")
  public String delete(@ModelAttribute("loginUser") User loginUser) throws Exception {
    if (loginUser == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    if (userService.delete(loginUser.getUserNo()) == 0) {
      throw new Exception("회원 탈퇴를 실패하였습니다.");
    }
    return "redirect:app/index";
  }

  @GetMapping("list")
  public void list(
      String keyword,
      @RequestParam(defaultValue = "1") int pageNo,
      @RequestParam(defaultValue = "5") int pageSize,
      Model model) throws Exception {

    if (pageNo < 1) {
      pageNo = 1;
    }
    if (pageSize < 3 || pageSize > 100) {
      pageSize = 5;
    }

    model.addAttribute("list", userService.list(keyword, pageNo, pageSize));

    int size = userService.size(keyword);
    int totalPage = size / pageSize;
    if (size % pageSize > 0) {
      totalPage++;
    }

    int prevPageNo = pageNo > 1 ? pageNo - 1 : 1;
    int nextPageNo = pageNo + 1;
    if (nextPageNo > totalPage) {
      nextPageNo = totalPage;
    }

    model.addAttribute("currPageNo", pageNo);
    model.addAttribute("prevPageNo", prevPageNo);
    model.addAttribute("nextPageNo", nextPageNo);
    model.addAttribute("totalPage", nextPageNo);
    model.addAttribute("size", size);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("keyword", keyword);
  }

  @GetMapping("recipeList")
  public void recipeList(@ModelAttribute("loginUser") User loginUser,
      int uNo, Model model) throws Exception {
    User user = userService.get(uNo);
    List<Recipe> recipeList = recipeService.userNoList(uNo);
    List<Follow> followerList = followService.FollowerList(uNo);
    List<Follow> followinglist = followService.FollowingList(uNo);

    int followCheck = -1;
    if(loginUser.getUserNo() != uNo) {
      Follow follow = new Follow();
      follow.setFollower(loginUser.getUserNo());
      follow.setFollowing(uNo);
      followCheck = followService.followCheck(follow);
    }

    model.addAttribute("followCheck", followCheck);
    model.addAttribute("user", user);
    model.addAttribute("recipeList", recipeList);

    int recipeSize = recipeList.size();
    int followerSize = followerList.size();
    int followingSize = followinglist.size();

    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);

  }

  @GetMapping("followerList")
  public void followerList(@ModelAttribute("loginUser") User loginUser,
      int uNo, Model model) throws Exception {
    User user = userService.get(uNo);
    List<Recipe> recipeList = recipeService.userNoList(uNo);
    List<Follow> followerList = followService.FollowerList(uNo);
    List<Follow> followinglist = followService.FollowingList(uNo);

    int followCheck = -1;
    if(loginUser.getUserNo() != uNo) {
      Follow follow = new Follow();
      follow.setFollower(loginUser.getUserNo());
      follow.setFollowing(uNo);
      followCheck = followService.followCheck(follow);
    }

    model.addAttribute("followCheck", followCheck);
    model.addAttribute("user", user);
    model.addAttribute("followerList", followerList);

    int recipeSize = recipeList.size();
    int followerSize = followerList.size();
    int followingSize = followinglist.size();

    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);
  }

  @GetMapping("followingList")
  public void followingList(@ModelAttribute("loginUser") User loginUser,
      int uNo, Model model) throws Exception {
    User user = userService.get(uNo);
    List<Recipe> recipeList = recipeService.userNoList(uNo);
    List<Follow> followerList = followService.FollowerList(uNo);
    List<Follow> followinglist = followService.FollowingList(uNo);

    int followCheck = -1;
    if(loginUser.getUserNo() != uNo) {
      Follow follow = new Follow();
      follow.setFollower(loginUser.getUserNo());
      follow.setFollowing(uNo);
      followCheck = followService.followCheck(follow);
    }

    model.addAttribute("followCheck", followCheck);
    model.addAttribute("user", user);
    model.addAttribute("followingList", followinglist);

    int recipeSize = recipeList.size();
    int followerSize = followerList.size();
    int followingSize = followinglist.size();

    model.addAttribute("recipeSize", recipeSize);
    model.addAttribute("followerSize", followerSize);
    model.addAttribute("followingSize", followingSize);
  }

  @GetMapping("follow")
  public String follow(@ModelAttribute("loginUser") User loginUser,
      int followUserNo,
      HttpServletRequest request) throws Exception {
    String referer = request.getHeader("Referer"); // 이전페이지
    Follow followUsers = new Follow();

    followUsers.setFollower(loginUser.getUserNo());
    followUsers.setFollowing(followUserNo);

    if (followService.follow(followUsers) == 0) {
      throw new Exception("팔로우를 실패하였습니다.");
    }
    return "redirect:"+ referer;
  }

  @GetMapping("unfollow")
  public String unfollow(@ModelAttribute("loginUser") User loginUser,
      int unfollowUserNo,
      HttpServletRequest request) throws Exception {
    String referer = request.getHeader("Referer");
    Follow unfollowUsers = new Follow();

    unfollowUsers.setFollower(loginUser.getUserNo());
    unfollowUsers.setFollowing(unfollowUserNo);

    if (followService.unfollow(unfollowUsers) == 0) {
      throw new Exception("언팔로우를 실패하였습니다.");
    }
    return "redirect:"+ referer;
  }
}