package com.jpkc.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class CM
{

	public static Map<String, String> sign(String jsapi_ticket, String url)
	{
		Map<String, String> ret = new HashMap<String, String>();
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		String string1;
		String signature = "";

		// 注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;
		System.out.println(string1);

		try
		{
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		ret.put("url", url);
		ret.put("jsapi_ticket", jsapi_ticket);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		return ret;
	}

	private static String byteToHex(final byte[] hash)
	{
		Formatter formatter = new Formatter();
		for (byte b : hash)
		{
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	private static String create_nonce_str()
	{
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	private static String create_timestamp()
	{
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	/**
	 * 产生25位的主键id,字符串yyMMddHHmmssSSS + 10位随机数
	 * 
	 * @return
	 */
	public static String getRandomTwentyFivePrimaryKeyId()
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String strTemp = sdf.format(calendar.getTime()) + getRandom_N_Number(3) + getRandom_N_Number(3) + getRandom_N_Number(3) + getRandom_N_Number(1);
		return strTemp;
	}

	/**
	 * 产生25位的主键id,字符串yyMMddHHmmssSSS + 10位随机数
	 * 
	 * @return
	 */
	public static String getRandomTwentyFivePrimaryKeyId(Calendar cal)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String strTemp = sdf.format(cal.getTime()) + getRandom_N_Number(3) + getRandom_N_Number(3) + getRandom_N_Number(3) + getRandom_N_Number(1);
		return strTemp;
	}

	/**
	 * 获取六位数的校验码
	 * 
	 * @return
	 */
	public static String getRandomSixNumber()
	{
		Random r = new Random();
		String s = "";
		for (int i = 0; i < 6; i++)
		{
			s += r.nextInt(10);
		}
		return s;
	}

	/**
	 * 获取n个随机数字字符串
	 * 
	 * @param n
	 * @return
	 */
	public static String getRandom_N_Number(int n)
	{
		Random r = new Random();
		String s = "";
		for (int i = 0; i < n; i++)
		{
			s += r.nextInt(10);
		}
		return s;
	}

	/**
	 * 判断字符串是不是null或长度为0的字符串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean validIsEmpty(String s)
	{
		if (s == null || s.equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 判断字符串是不是null或长度为0的字符串(如果前后有空格,清除空格号再判断.)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean validIsEmptyWithTrim(String s)
	{
		if (s == null || s.equals("") || s.trim().equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 判断字符串列表中是不是有一个字符串为null或长度为0的字符串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean validAtLeastOneIsEmpty(List<String> strList)
	{
		for (String s : strList)
		{
			if (validIsEmpty(s) == true)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 得到图片路径的列表
	 * 
	 * @param htmlStr
	 *            传过来的html文档
	 * @param imgMaxNum
	 *            最多返回的图片数
	 * @return 返回图片地址的列表,0张图片时返回null
	 */
	public static List<String> getImgSrcList(String htmlStr, int imgMaxNum)
	{
		List<String> imgSrcList = new ArrayList<String>();
		Parser parser;
		try
		{
			parser = new Parser(htmlStr);
			// 获取img标签
			NodeFilter filter = new TagNameFilter("img");
			NodeList nodes = parser.extractAllNodesThatMatch(filter);

			if (nodes != null && nodes.size() != 0)
			{
				int imgNum = nodes.size() < imgMaxNum ? nodes.size() : imgMaxNum;
				for (int i = 0; i < imgNum; i++)
				{
					// 转换成普通的tag标签
					Tag tag = (Tag) nodes.elementAt(i);
					// Node textnode = (Node) nodes.elementAt(i);
					imgSrcList.add(tag.getAttribute("src"));
				}
				return imgSrcList;
			}
			else
			{
				return null;
			}
		}
		catch (ParserException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 得到视频路径的列表
	 * 
	 * @param htmlStr
	 *            传过来的html文档
	 * @param imgMaxNum
	 *            最多返回的视频数
	 * @return 返回视频地址的列表,0个视频时返回null
	 */
	public static List<String> getVideoSrcList(String htmlStr, int imgMaxNum)
	{
		List<String> imgSrcList = new ArrayList<String>();
		Parser parser;
		try
		{
			parser = new Parser(htmlStr);
			// 获取img标签
			NodeFilter filter = new TagNameFilter("a");
			NodeList nodes = parser.extractAllNodesThatMatch(filter);

			if (nodes != null && nodes.size() != 0)
			{
				int imgNum = imgMaxNum;
				for (int i = 0; i < imgNum; i++)
				{
					// 转换成普通的tag标签
					Tag tag = (Tag) nodes.elementAt(i);
					String href = tag.getAttribute("href");
					if (href.endsWith(".mp4") || href.endsWith(".flv"))
					{
						imgSrcList.add(href);
						imgNum--;
					}
					if (imgNum <= 0)
					{
						break;
					}
				}
				if (imgSrcList.size() > 0)
				{
					return imgSrcList;
				}
			}
			else
			{
				return null;
			}
		}
		catch (ParserException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * 得到PDF路径的列表
	 * 
	 * @param htmlStr
	 *            传过来的html文档
	 * @param imgMaxNum
	 *            最多返回的PDF数
	 * @return 返回PDF地址的列表,0个PDF时返回null
	 */
	public static List<String> getPDFSrcList(String htmlStr, int imgMaxNum)
	{
		List<String> imgSrcList = new ArrayList<String>();
		Parser parser;
		try
		{
			parser = new Parser(htmlStr);
			// 获取img标签
			NodeFilter filter = new TagNameFilter("a");
			NodeList nodes = parser.extractAllNodesThatMatch(filter);

			if (nodes != null && nodes.size() != 0)
			{
				int imgNum = imgMaxNum;
				for (int i = 0; i < imgNum; i++)
				{
					// 转换成普通的tag标签
					Tag tag = (Tag) nodes.elementAt(i);
					String href = tag.getAttribute("href");
					if (href.endsWith(".pdf"))
					{
						imgSrcList.add(href);
						imgNum--;
					}
					if (imgNum <= 0)
					{
						break;
					}
				}
				if (imgSrcList.size() > 0)
				{
					return imgSrcList;
				}
			}
			else
			{
				return null;
			}
		}
		catch (ParserException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	// 与操作系统有关的变量
	public static String fileSeparator = System.getProperty("file.separator");
	public static String lineSeparator = System.getProperty("line.separator");

	public static final char mapTable[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
			'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8' };

	/**
	 * 功能：生成彩色验证码图片
	 * 
	 * @param width
	 *            参数wedth为生成图片的宽度
	 * @param height
	 *            参数height为生成图片的高度
	 * @param os
	 *            参数os为页面的输出流
	 * @return
	 */
	public static String getCertPic(int width, int height, OutputStream os)
	{
		if (width <= 0)
			width = 60;
		if (height <= 0)
			height = 30;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 设定背景颜色
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		// 画边框
		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);
		// 随机产生的验证码
		String strEnsure = "";
		// 4代表4为验证码，如果要产生更多位的验证码，则加大数值
		for (int i = 0; i < 4; ++i)
		{
			strEnsure += mapTable[(int) (mapTable.length * Math.random())];
		}
		// 将认证码显示到图像中，如果要生成更多位的验证码，增加drawString语句
		g.setColor(Color.black);
		// 字体Atlantic Inline
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		String str = strEnsure.substring(0, 1);
		g.drawString(str, 2, 26);
		str = strEnsure.substring(1, 2);
		g.setColor(Color.blue);
		g.drawString(str, 22, 30);
		str = strEnsure.substring(2, 3);
		g.setColor(Color.red);
		g.drawString(str, 42, 24);
		str = strEnsure.substring(3, 4);
		g.setColor(Color.black);
		g.drawString(str, 62, 28);
		// 随机产生30个干扰点
		Random rand = new Random();
		for (int i = 0; i < 10; i++)
		{
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			g.drawOval(x, y, 2, 2);
		}
		// 释放图形上下文
		g.dispose();
		try
		{
			// 输出图形到页面
			ImageIO.write(image, "JPEG", os);

		}
		catch (IOException e)
		{
			return "";
		}
		return strEnsure;
	}

	/**
	 * 从 href1,href2,href3得到href1
	 * 
	 * @param somePictureSrcStr
	 * @return
	 */
	public static String fromSomePictureSrcToOneSrc(String somePictureSrcStr)
	{
		String[] srcs = somePictureSrcStr.split(",");
		return srcs[0];
	}

	/**
	 * 从 href1,href2,href3得到List<String> 列表[href1],[href2],[href3]
	 * 
	 * @param somePictureSrcStr
	 * @return
	 */
	public static List<String> fromSomePictureSrcToOneList(String somePictureSrcStr)
	{
		List<String> pictureList = new ArrayList<String>();
		String[] srcs = somePictureSrcStr.split(",");
		for (String str : srcs)
		{
			pictureList.add(str);
		}
		return pictureList;
	}

	/**
	 * 从List<String> 列表[href1],[href2],[href3]得到字符串href1,href2,href3
	 * 
	 * @param PictureSrcStrList
	 * @return
	 */
	public static String fromPictureSrcListToOneListStr(List<String> PictureSrcStrList)
	{
		String temp = "";
		if (PictureSrcStrList.size() == 0)
		{
			return temp;
		}
		for (int i = 0; i < PictureSrcStrList.size(); i++)
		{
			temp += PictureSrcStrList.get(i) + ",";
		}
		return temp.substring(0, temp.length() - 1);
	}

	/**
	 * 从字符串href1,href2,href3得到图片标签字符串< img src="href1">< /br>< img src="href2"><
	 * /br>< img src="href3">< /br>
	 * 
	 * @param somePictureSrcStr
	 * @return
	 */
	public static String fromSomePictureSrcToImgTagString(String somePictureSrcStr)
	{
		String[] srcs = somePictureSrcStr.split(",");
		String strTemp = "";
		for (int i = 0; i < srcs.length; i++)
		{
			strTemp += "<img src=\"" + srcs[i] + "\"></br>";
		}
		return strTemp;
	}

	public static String getCurrentTimeStr()
	{
		Calendar c = Calendar.getInstance();
		String str = "" + c.get(Calendar.HOUR_OF_DAY) + c.get(Calendar.MINUTE) + c.get(Calendar.SECOND) + c.get(Calendar.MILLISECOND);
		return str;
	}

	/**
	 * 将汉字转换为%E4%BD%A0形式
	 * 
	 * @param s
	 * @return
	 */
	public static String toUtf8String(String s)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c >= 0 && c <= 255)
			{
				sb.append(c);
			}
			else
			{
				byte[] b;
				try
				{
					b = String.valueOf(c).getBytes("utf-8");
				}
				catch (Exception ex)
				{
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++)
				{
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 将%E4%BD%A0转换为汉字
	 * 
	 * @param s
	 * @return
	 */
	public static String tounescape(String s)
	{
		StringBuffer sbuf = new StringBuffer();
		int l = s.length();
		int ch = -1;
		int b, sumb = 0;
		for (int i = 0, more = -1; i < l; i++)
		{
			/* Get next byte b from URL segment s */
			switch (ch = s.charAt(i))
			{
				case '%':
					ch = s.charAt(++i);
					int hb = (Character.isDigit((char) ch) ? ch - '0' : 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
					ch = s.charAt(++i);
					int lb = (Character.isDigit((char) ch) ? ch - '0' : 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
					b = (hb << 4) | lb;
					break;
				case '+':
					b = ' ';
					break;
				default:
					b = ch;
			}
			/* Decode byte b as UTF-8, sumb collects incomplete chars */
			if ((b & 0xc0) == 0x80)
			{ // 10xxxxxx (continuation byte)
				sumb = (sumb << 6) | (b & 0x3f); // Add 6 bits to sumb
				if (--more == 0)
					sbuf.append((char) sumb); // Add char to sbuf
			}
			else if ((b & 0x80) == 0x00)
			{ // 0xxxxxxx (yields 7 bits)
				sbuf.append((char) b); // Store in sbuf
			}
			else if ((b & 0xe0) == 0xc0)
			{ // 110xxxxx (yields 5 bits)
				sumb = b & 0x1f;
				more = 1; // Expect 1 more byte
			}
			else if ((b & 0xf0) == 0xe0)
			{ // 1110xxxx (yields 4 bits)
				sumb = b & 0x0f;
				more = 2; // Expect 2 more bytes
			}
			else if ((b & 0xf8) == 0xf0)
			{ // 11110xxx (yields 3 bits)
				sumb = b & 0x07;
				more = 3; // Expect 3 more bytes
			}
			else if ((b & 0xfc) == 0xf8)
			{ // 111110xx (yields 2 bits)
				sumb = b & 0x03;
				more = 4; // Expect 4 more bytes
			}
			else
			/* if ((b & 0xfe) == 0xfc) */{ // 1111110x (yields 1 bit)
				sumb = b & 0x01;
				more = 5; // Expect 5 more bytes
			}
			/* We don't test if the UTF-8 encoding is well-formed */
		}
		return sbuf.toString();
	}

	public static String getStart8Character(String str)
	{
		if (str.length() >= 8)
		{
			return str.substring(0, 7);
		}
		else
		{
			return str;
		}
	}

	public static String getStartNCharacter(String str, int n)
	{
		if (str.length() >= n)
		{
			return str.substring(0, n - 1);
		}
		else
		{
			return str;
		}
	}

	public static String getIpAddr(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("X-Real-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String getNotifyReturnXML(String return_code, String return_msg)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		sb.append("<return_code><![CDATA[" + return_code + "]]></return_code>");
		sb.append("<return_msg><![CDATA[" + return_msg + "]]></return_msg>");
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * 得到随机的int32位整数
	 * 
	 * @return
	 */
	public static int getInt32RandomNumber()
	{
		Random r = new Random();
		String s = "";
		s += r.nextInt(4);
		for (int i = 0; i < 9; i++)
		{
			s += r.nextInt(10);
		}
		return Integer.parseInt(s) + 1;
	}

	/**
	 * 得到随机的小于100000的整数
	 * 
	 * @return
	 */
	public static int getIntRandomNumberLessThan100000()
	{
		Random r = new Random();
		String s = "";
		for (int i = 0; i < 5; i++)
		{
			s += r.nextInt(10);
		}
		return Integer.parseInt(s) + 1;
	}

	/**
	 * 删除某个文件夹下的所有文件夹和文件
	 * 
	 * @param delpath
	 *            String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return boolean
	 */
	public static boolean deletefile(String delpath) throws Exception
	{
		try
		{
			File file = new File(delpath);
			// 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
			if (!file.isDirectory())
			{
				file.delete();
			}
			else if (file.isDirectory())
			{
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++)
				{
					File delfile = new File(delpath + "\\" + filelist[i]);
					if (!delfile.isDirectory())
					{
						delfile.delete();
						// System.out.println(delfile.getAbsolutePath() +
						// "删除文件成功");
					}
					else if (delfile.isDirectory())
					{
						deletefile(delpath + "\\" + filelist[i]);
					}
				}
				// System.out.println(file.getAbsolutePath() + "删除成功");
				file.delete();
			}

		}
		catch (FileNotFoundException e)
		{
			// System.out.println("deletefile() Exception:" + e.getMessage());
		}
		return true;
	}

	public static String filterEmoji(String str)
	{
		return str.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
	}

	/**
	 * 得到当前时间,格式为yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeStrNow()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(Calendar.getInstance().getTime());
	}

	/**
	 * 根据微信性别编码获得性别字符串,男,女
	 * 
	 * @param sexNumber
	 * @return
	 */
	public static String getSexFromWechatNumber(String sexNumber)
	{
		String sex = "";
		switch (sexNumber)
		{
			case "1":
				sex = "男";
				break;
			case "2":
				sex = "女";
				break;

			default:
				break;
		}
		return sex;
	}

	/**
	 * 根据定时任务时间得到周报表将统计的开始时间和结束时间
	 * 
	 * @param now_date
	 * @return
	 */
	public static Date[] getWeekReportStartDateAndEndDate(Date now_date)
	{
		Date startDate = null;
		Date endDate = null;

		Calendar cal = Calendar.getInstance();
		cal.setTime(now_date);
		int DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH);
		if (DAY_OF_MONTH >= 1 && DAY_OF_MONTH <= 7)
		{
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.add(Calendar.SECOND, -1);
			endDate = cal.getTime();

			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			startDate = cal.getTime();
		}
		else if (DAY_OF_MONTH >= 8 && DAY_OF_MONTH <= 14)
		{
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			startDate = cal.getTime();

			cal.set(Calendar.DAY_OF_MONTH, 7);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 0);
			endDate = cal.getTime();
		}
		else if (DAY_OF_MONTH >= 15 && DAY_OF_MONTH <= 21)
		{
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			startDate = cal.getTime();

			cal.set(Calendar.DAY_OF_MONTH, 14);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 0);
			endDate = cal.getTime();
		}
		else if (DAY_OF_MONTH >= 22 && DAY_OF_MONTH <= 31)
		{
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			startDate = cal.getTime();

			cal.set(Calendar.DAY_OF_MONTH, 21);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 0);
			endDate = cal.getTime();
		}

		Date[] returnDateArray = new Date[] { startDate, endDate };
		return returnDateArray;
	}

	/**
	 * 根据定时任务时间得到月报表将统计的开始时间和结束时间
	 * 
	 * @param now_date
	 * @return
	 */
	public static Date[] getMonthReportStartDateAndEndDate(Date now_date)
	{
		Date startDate = null;
		Date endDate = null;

		Calendar cal = Calendar.getInstance();
		cal.setTime(now_date);
		int DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH);
		if (DAY_OF_MONTH == 1)
		{
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.add(Calendar.SECOND, -1);
			endDate = cal.getTime();

			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			startDate = cal.getTime();
		}
		else if (DAY_OF_MONTH >= 2 && DAY_OF_MONTH <= 31)
		{
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			startDate = cal.getTime();

			cal.set(Calendar.DAY_OF_MONTH, DAY_OF_MONTH - 1);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 0);
			endDate = cal.getTime();
		}

		Date[] returnDateArray = new Date[] { startDate, endDate };
		return returnDateArray;
	}

	/**
	 * 根据日期得到周次字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekStringByDate(Date date)
	{
		String str = "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH);
		if (DAY_OF_MONTH >= 1 && DAY_OF_MONTH <= 7)
		{
			str = "第一周";
		}
		else if (DAY_OF_MONTH >= 8 && DAY_OF_MONTH <= 14)
		{
			str = "第二周";
		}
		else if (DAY_OF_MONTH >= 15 && DAY_OF_MONTH <= 21)
		{
			str = "第三周";
		}
		else if (DAY_OF_MONTH >= 22 && DAY_OF_MONTH <= 31)
		{
			str = "第四周";
		}

		return str;
	}

	/**
	 * 判断这个日期所在周次是否需要高亮显示
	 * 
	 * @param date
	 * @return
	 */
	public static boolean validWeekHighlight(Date date)
	{
		boolean is_highlight = false;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH);
		if (DAY_OF_MONTH >= 1 && DAY_OF_MONTH <= 7)
		{
			is_highlight = true;
		}
		else if (DAY_OF_MONTH >= 8 && DAY_OF_MONTH <= 14)
		{
			is_highlight = false;
		}
		else if (DAY_OF_MONTH >= 15 && DAY_OF_MONTH <= 21)
		{
			is_highlight = true;
		}
		else if (DAY_OF_MONTH >= 22 && DAY_OF_MONTH <= 31)
		{
			is_highlight = false;
		}

		return is_highlight;
	}

	/**
	 * 创建一个文件,如果不存在路径,连带路径创建
	 * 
	 * @param destFileName
	 * @return
	 */
	public static boolean createFileWithDirs(String destFileName)
	{
		File file = new File(destFileName);
		if (file.exists())
		{
			System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
			return false;
		}
		if (destFileName.endsWith(File.separator))
		{
			System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
			return false;
		}
		// 判断目标文件所在的目录是否存在
		if (!file.getParentFile().exists())
		{
			// 如果目标文件所在的目录不存在，则创建父目录
			System.out.println("目标文件所在目录不存在，准备创建它！");
			if (!file.getParentFile().mkdirs())
			{
				System.out.println("创建目标文件所在目录失败！");
				return false;
			}
		}
		// 创建目标文件
		try
		{
			if (file.createNewFile())
			{
				System.out.println("创建单个文件" + destFileName + "成功！");
				return true;
			}
			else
			{
				System.out.println("创建单个文件" + destFileName + "失败！");
				return false;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());
			return false;
		}
	}
}
