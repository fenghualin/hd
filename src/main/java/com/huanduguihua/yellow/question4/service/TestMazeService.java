package com.huanduguihua.yellow.question4.service;

import java.util.List;

import com.huanduguihua.system.service.DefaultService;
import com.huanduguihua.yellow.question4.bean.TestMaze;

public interface TestMazeService extends DefaultService{

	public void save(TestMaze testMaze);
	public List<TestMaze> list(String sql, String uid, String kinds);
}
