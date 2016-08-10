package com.devcolibri.servlet;

import com.devcolibri.bean.UserBean;
import com.devcolibri.entity.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class MainServlet extends HttpServlet{

    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<User> allUser = userBean.getAll();

        req.setAttribute("users", allUser);

        req.getRequestDispatcher("/list.jsp").forward(req, resp);

    }

}
