package com.oijoa.web.admin;

import java.io.File;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.oijoa.domain.Notice;
import com.oijoa.domain.Order;
import com.oijoa.domain.Product;
import com.oijoa.domain.Qna;
import com.oijoa.domain.User;
import com.oijoa.service.NoticeService;
import com.oijoa.service.NoticeTypeService;
import com.oijoa.service.OrderService;
import com.oijoa.service.ProductService;
import com.oijoa.service.QnaService;
import com.oijoa.service.UserService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  ProductService productService;

  @Autowired
  ServletContext servletContext;
  @Autowired
  UserService userService;
  @Autowired
  OrderService orderService;
  @Autowired
  QnaService qnaService;
  @Autowired
  NoticeService noticeService;
  @Autowired
  NoticeTypeService noticeTypeService;

  @GetMapping("userList")
  public void userList(Model model) throws Exception {
    model.addAttribute("userList", userService.list());
  }

  @GetMapping("userDetail")
  public String userDetail(int no, HttpSession session) throws Exception {
    session.setAttribute("thisUser", userService.get(no));
    return "redirect:userList";
  }

  @PostMapping("userUpdate")
  public String userUpdate(User user, HttpSession session) throws Exception {
    userService.update(user);
    session.setAttribute("thisUser", userService.get(user.getUserNo()));
    return "redirect:userList";
  }

  @RequestMapping("productList")
  public void productList(Model model) throws Exception {
    model.addAttribute("list", productService.list(null));
  }

  @RequestMapping("productAdd")
  public String productAdd(String title, String content, int price, int stock, int discount,
      MultipartFile photoFile) throws Exception {
    Product product = new Product();
    product.setTitle(title);
    product.setContent(content);
    product.setDiscount(discount);
    product.setPrice(price);
    product.setStock(stock);


    String filename = UUID.randomUUID().toString();
    String saveFilePath = servletContext.getRealPath("/upload/" + filename);
    photoFile.transferTo(new File(saveFilePath));

    product.setPhoto(filename);
    generatePhotoThumbnail(saveFilePath);


    productService.add(product);
    return "redirect:productList";
  }

  @GetMapping("productDetail")
  public String productDetail(int no, HttpSession session) throws Exception {
    session.setAttribute("thisProduct", productService.get(no));
    return "redirect:productList";
  }

  @PostMapping("productUpdate")
  public String productUpdate(Product product, HttpSession session) {
    productService.update(product);
    session.setAttribute("thisProduct", productService.get(product.getProductNo()));
    return "redirect:productList";
  }

  @RequestMapping("productForm")
  public void productForm() throws Exception {}


  @RequestMapping("orderList")
  public void orderList(Model model) throws Exception {
    model.addAttribute("orderList", orderService.list());
  }

  @GetMapping("orderDetail")
  public String orderDetail(int no, HttpSession session) throws Exception {
    session.setAttribute("thisOrder", orderService.get(no));
    return "redirect:orderList";
  }

  @PostMapping("orderUpdate")
  public String orderUpdate(Order order, HttpSession session) throws Exception {
    orderService.update(order);
    session.setAttribute("thisOrder", orderService.get(order.getOrderNo()));
    return "redirect:orderList";
  }

  @RequestMapping("qnaList")
  public void qnaList(Model model) throws Exception {
    model.addAttribute("qnaList", qnaService.list());
  }

  @GetMapping("qnaDetail")
  public String qnaDetail(int no, HttpSession session) throws Exception {
    session.setAttribute("thisQna", qnaService.get(no));
    return "redirect:qnaList";
  }

  @PostMapping("qnaUpdate")
  public String qnaUpdate(Qna qna, HttpSession session) throws Exception {
    qnaService.update(qna);
    session.setAttribute("thisQna", qnaService.get(qna.getQnaNo()));
    return "redirect:qnaList";
  }

  @RequestMapping("noticeList")
  public void noticeList(Model model) throws Exception {
    model.addAttribute("noticeList", noticeService.list());
  }

  @GetMapping("noticeDetail")
  public String noticeDetail(int no, HttpSession session) throws Exception {
    session.setAttribute("thisNotice", noticeService.get(no));
    return "redirect:noticeList";
  }

  @PostMapping("noticeUpdate")
  public String noticeUpdate(Notice notice, int noticeTypeNo, HttpSession session)
      throws Exception {
    notice.setNoticeType(noticeTypeService.get(noticeTypeNo));
    noticeService.update(notice);
    session.setAttribute("thisNotice", noticeService.get(notice.getNoticeNo()));
    return "redirect:noticeList";
  }

  @RequestMapping("noticeForm")
  public void noticeForm(Model model) throws Exception {
    model.addAttribute("noticeList", noticeService.list());
  }


  @RequestMapping("noticeAdd")
  public String noticeAdd(String title, String content, int noticeTypeNo) throws Exception {
    Notice notice = new Notice();
    notice.setTitle(title);
    notice.setNoticeType(noticeTypeService.get(noticeTypeNo));
    notice.setContent(content);
    noticeService.add(notice);
    return "redirect:noticeList";
  }


  private void generatePhotoThumbnail(String saveFilePath) {
    try {
      Thumbnails.of(saveFilePath).size(80, 80).outputFormat("jpg").crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_80x80";
            }
          });

      Thumbnails.of(saveFilePath).size(200, 200).outputFormat("jpg").crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_200x200";
            }
          });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
