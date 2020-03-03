package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import entity.ReplaceDto;

public class CmdUtils {

	private static final Logger logger = LogManager.getLogger(CmdUtils.class);

	public static List<String> runCMD(String cmd, List<ReplaceDto> replaceStrList) {// throws IOException, InterruptedException
		final String METHOD_NAME = "runCMD";
		BufferedReader br = null;
		Process p = null;
		List<String> res = new ArrayList<String>();
		try {
			logger.debug(METHOD_NAME + "#command: " + cmd);
			p = Runtime.getRuntime().exec(cmd);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));//执行返回结果
			StringBuilder builder = new StringBuilder();
			String readLine = br.readLine();
			while (readLine != null) {
				builder.append(readLine);
				readLine = readLine.replace("\t", "");
				if(CollectionUtils.isNotEmpty(replaceStrList)) {
					for (ReplaceDto rep : replaceStrList) {
						readLine = readLine.replace(rep.getOriginal(), rep.getTarget());
					}
				}
				if(StringUtils.isNotBlank(readLine)) {
					res.add(readLine);
				}
				readLine = br.readLine();
			}
			logger.debug(METHOD_NAME + "#readLine: " + builder.toString());

			p.waitFor();
			int i = p.exitValue();
			logger.debug(METHOD_NAME + "#exitValue = " + i);

			if (br != null) {
				br.close();
			}

			if (i == 0) {
				logger.debug(METHOD_NAME+"#res :" + JSON.toJSONString(res));
				return res;
			}
		} catch (Exception e) {
			logger.debug(METHOD_NAME + "#ErrMsg=" + e.getMessage());
			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			e.printStackTrace();
		} finally {

		}
		return res;
	}

//	public static void main(String[] args) {
//		List<ReplaceDto> list = new ArrayList<ReplaceDto>();
//		ReplaceDto temp1 = new ReplaceDto("List of devices attached", "");
//		ReplaceDto temp2 = new ReplaceDto("device", "");
//		list.add(temp1);
//		list.add(temp2);
//		List<String> res = CmdUtils.runCMD("adb devices", list );
//		System.out.println(JSON.toJSONString(res));
//	}

}
