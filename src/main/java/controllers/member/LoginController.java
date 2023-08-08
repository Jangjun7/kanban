package controllers.member;

import commons.ViewUtils;
import controllers.Controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.View;

public class LoginController implements Controller {
    public void get(HttpServletRequest req, HttpServletResponse resp) {
        ViewUtils.load(req, resp, "member", "login");
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) {

    }
}
