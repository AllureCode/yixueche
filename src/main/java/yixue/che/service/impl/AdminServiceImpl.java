package yixue.che.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yixue.che.bean.Admin;
import yixue.che.mapper.IAdminMapper;
import yixue.che.service.IAdminService;
import yixue.che.util.Tools;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminMapper adminMapper;

    @Override
    public Admin login(String username, String password)  {
        return adminMapper.login(username,password);
    }

    @Override
    public long count() throws Exception {
        return adminMapper.count();
    }

    @Override
    public List<Admin> findByPage(int currentPage, int pageSize, String query) {
        List<Admin> list = new ArrayList<Admin>();
        PageHelper.startPage(currentPage,pageSize);
        if (!Tools.isEmpty(query)){
            list = adminMapper.findListByQuery("%" + query + "%");
        }else {
            list = adminMapper.findList();
        }
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(list);
        return pageInfo.getList();
    }

    @Override
    public Admin findById(Integer id) throws Exception {
        return adminMapper.findById(id);
    }

    @Override
    public Admin findByUserName(String userName) throws Exception {
        return adminMapper.findByUserName(userName);
    }

    @Override
    public void save(Admin admin) throws Exception {
        adminMapper.save(admin);
    }

    @Override
    public void update(Admin admin) throws Exception {
        adminMapper.update(admin);
    }

    @Override
    public void deleteByid(Integer id) throws Exception {
        adminMapper.deleteByid(id);
    }
}
