package com.movie.service.admin.impl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.movie.dao.admin.MovieDao;
import com.movie.dao.admin.MovieTypeDao;
import com.movie.pojo.Movie;
import com.movie.pojo.MovieType;
import com.movie.pojo.Notice;
import com.movie.pojo.PageInfo;
import com.movie.service.admin.MovieService;
import com.mysql.fabric.xmlrpc.base.Data;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private MovieTypeDao movieTypeDao;
	
	private SimpleDateFormat releaseTimeLocal = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
	
	private SimpleDateFormat releaseTime = new SimpleDateFormat("yyyy-MM-dd hh:mm");

	@Override
	public String toMovie(Model model, Integer pageNo) {
		JSONObject json = selectMovieByPage(pageNo,null,null);
		List<Movie> list = (List<Movie>) json.get("allMovie");
		model.addAttribute("allMovie", list); 
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", json.get("totalPage"));
		return "admin/movie";
	}

	@Override
	public JSONObject selectMovieByPage(Integer pageNo ,String code, String myKey) {
		JSONObject jsonObject = new JSONObject();
		PageInfo pageInfo = new PageInfo(pageNo,10);
		List<Movie> movieList = movieDao.selectMovieByPage(pageInfo,code,myKey); 
		movieList.forEach(movie ->{
			Date releaseDate = movie.getReleaseTime();
			long nowTime = new Date().getTime();
			long releaseTime = releaseDate.getTime();
			movie.setPlay(nowTime >= releaseTime?1:0);
		});
		jsonObject.put("allMovie", movieList);
		jsonObject.put("pageNo", pageNo); 
		jsonObject.put("totalPage", movieList !=null?movieList.size():0);
		return jsonObject;
	}

	@Override
	public String toAddMovie(Model model) {
		List<MovieType> movieType = movieTypeDao.selectAllMovieType(); 
		model.addAttribute("movieTypeList",movieType);
		return "admin/addMovie";
	}
	
	@Override
	public JSONObject deleteMovies(String[] movieIds) {
		JSONObject jsonObject = new JSONObject();
		List<String> movieIdList= Arrays.asList(movieIds);
		jsonObject.put("success", movieDao.deleteMovies(movieIdList).equals(movieIds.length));
		return jsonObject;
	}

	@Override
	public JSONObject deleteOneMovie(String movieId) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", movieDao.deleteOneMovie(movieId) > 0);
		return jsonObject;
	}

	@Override
	public String addOrUpdateMovie(Movie movie, MultipartFile file) {
		try {
			String fullName = file.getOriginalFilename(); 
			if(fullName.length() > 0){
				String realpath = "D:\\aa";
				//获取文件后缀
				String suffix = FilenameUtils.getExtension(fullName);
				String prefix = UUID.randomUUID().toString().replaceAll("-", "");
				String fileName = realpath + prefix +"."+ suffix;
				File newFile = new File(fileName);
				movie.setImg(prefix+"."+suffix);
				file.transferTo(newFile);
			}
			movie.setReleaseTime(releaseTime.parse(movie.getReleaseTimeLocal()));
			//更新
			if(StringUtils.isNotEmpty(movie.getId())) {
				if(movie.getSurplus() > 40) {
					movie.setSurplus(40);
				}
				if(movie.getPlay().equals(1)) {
					movie.setReleaseTime(new Date());
				}
				movieDao.updateMovie(movie);
			}else {//新增
				movieDao.addNewMovie(movie);
			}
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "forward:/admin/movie/movie";
	}

	@Override
	public String movieDetails(String movieId, Model model) {
		Movie movie = movieDao.movieDetails(movieId);
		List<MovieType> movieType = movieTypeDao.selectAllMovieType(); 
		Date releaseDate = movie.getReleaseTime();
		long nowTime = new Date().getTime();
		long releaseTime = releaseDate.getTime();
		movie.setPlay(nowTime >= releaseTime?1:0);
		movie.setReleaseTimeLocal(releaseTimeLocal.format(releaseDate));
		model.addAttribute("movie", movie);
		model.addAttribute("movieTypeList",movieType);
		return "admin/addMovie";
	}

	@Override
	public List<Movie> selectMovieByType(Model model, Integer pageNo, String typeCode) {
		PageInfo pageInfo = new PageInfo(pageNo, 10);
		return movieDao.selectMovieByType(pageInfo,typeCode);
	}

	@Override
	public String search(Model model,String mykey) {
		List<Movie> movieList = null;
		if(StringUtils.isNotEmpty(mykey)) {
			movieList = movieDao.search(mykey);
			movieList.forEach(movie ->{
				Date releaseDate = movie.getReleaseTime();
				long nowTime = new Date().getTime();
				long releaseTime = releaseDate.getTime();
				movie.setPlay(nowTime >= releaseTime?1:0);
			});
		}
		model.addAttribute("searchlist",movieList);
		return "before/searchResult";
	}

	@Override
	public List<Movie> selectMovieByPageIndex(Model model, Integer pageNo, String code, String myKey) {
		JSONObject json = selectMovieByPage(pageNo,code,myKey);
		List<Movie> list = (List<Movie>) json.get("allMovie");
		model.addAttribute("allMovieIndex", list); 
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalPage", json.get("totalPage"));
		return list;
	}

	@Override
	public Movie selectMovieById(String movieId) {
		return movieDao.selectMovieById(movieId);
	}

	@Override
	public void updateMovieNum(String movieId, Integer num) {
		movieDao.updateMovieNum(movieId,num);
	}
}
