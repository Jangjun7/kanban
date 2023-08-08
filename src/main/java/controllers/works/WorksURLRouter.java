package controllers.works;

import controllers.Controller;
import controllers.URLRouter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.View;

public class WorksURLRouter implements URLRouter {

    @Override
    public void route(HttpServletRequest req, HttpServletResponse resp, String location) {
        String mode = getMode(req.getRequestURI(),location);
        mode = mode == null || mode.isBlank() ? "list" : mode;
        if(mode.matches("\\d")){ // 작업 조회 모드
            mode = "view";
        }

        Controller controller = null;
        if(mode.equals("list")){
            controller = new ListController();
        } else if(mode.equals("view")){
            controller = new ViewController();
        } else if(mode.equals("add") || mode.equals("edit")){
            controller = new SaveController();
        } else if(mode.equals("delete")){
            controller = new DeleteController();
        }

        if (controller == null) return;

        String method = req.getMethod().toUpperCase(); // 요청 메서드
        if (method.equals("POST")) {
            controller.post(req, resp);
        } else {
            controller.get(req, resp);
        }
    }
}
