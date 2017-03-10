package com.dh.greendao.presenter;

import com.dh.greendao.App;
import com.dh.greendao.gen.UserBeanDao;
import com.dh.greendao.model.UserBean;
import com.dh.greendao.ui.IUserTestView;

import java.util.List;

/**
 * Created by hpc on 2017-3-10.
 */

public class UserTestPresenter {
    private IUserTestView iUserTestView;

    public UserTestPresenter(IUserTestView iUserTestView) {
        this.iUserTestView = iUserTestView;
    }

    public void insertUser() {
        UserBean userBean = new UserBean();
        userBean.setName(iUserTestView.getEditTextContent());
        userBean.setPwd("22122");
        UserBeanDao mUserDao = App.getDaoSession().getUserBeanDao();
        List<UserBean> users = mUserDao.loadAll();
        if (users.size() <= 0)
            mUserDao.insert(userBean);
        else {
            userBean.setId(users.get(0).getId());
            mUserDao.update(userBean);
        }
        List<UserBean> userNew = mUserDao.loadAll();
        if (userNew.size() > 0) {
            iUserTestView.showTextContent(userNew.get(0).getName());
        }
    }
}
