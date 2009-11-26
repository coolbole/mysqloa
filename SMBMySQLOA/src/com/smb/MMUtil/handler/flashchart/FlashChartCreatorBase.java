/**
 * Copyright (c) SMB OpenSoftWare Team
 * All rights reserved.
 * 
 * Redistribution and use in source and binary OpenSoftWare OTS project, 
 * with or without modification, are permitted provided 
 * that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above 
 * copyright notice, this list of conditions and the 
 * following  disclaimer.
 * 
 * 2)  Redistributions in binary form must reproduce the 
 * above copyright notice, this list of conditions and 
 * the following disclaimer in the documentation and/or 
 * other materials provided with the distribution.
 * 
 * 3) Neither the name of "H.E." or "Yi Huang" nor 
 * the names of its contributors may be used to endorse 
 * or promote products derived from this software without 
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT 
 * HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, 
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL 
 * THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE 
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE
 * 
 * This file creation date: 2009-7-20 -  下午05:19:46 
 * The OpenSoftWare OTS Project
 * http://code.google.com/p/smbopensoft/
 * Author: H.E.
 * Email: njthnet@gmail.com
 */
package com.smb.MMUtil.handler.flashchart;

/**
 * @author huangyi
 *
 */
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @deprecated Class FusionChartsCreator is deprecated
 */

public class FlashChartCreatorBase {

	public static String addCacheToDataURL(String strDataURL) {
		String cachedURL = strDataURL;
		Calendar nowCal = Calendar.getInstance();
		Date now = nowCal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH_mm_ss a");
		String strNow = sdf.format(now);
		try {
			if (strDataURL.indexOf("?") > 0)
				cachedURL = (new StringBuilder(String.valueOf(strDataURL)))
						.append("&FCCurrTime=").append(
								URLEncoder.encode(strNow, "UTF-8")).toString();
			else
				cachedURL = (new StringBuilder(String.valueOf(strDataURL)))
						.append("?FCCurrTime=").append(
								URLEncoder.encode(strNow, "UTF-8")).toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			cachedURL = (new StringBuilder(String.valueOf(strDataURL))).append(
					"?FCCurrTime=").append(strNow).toString();
		}
		return cachedURL;
	}

	public static String createChart(String chartSWF, String strURL,
			String strXML, String chartId, int chartWidth, int chartHeight,
			boolean debugMode, boolean registerWithJS) {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("\t\t<!-- START Script Block for Chart-->\n");
		strBuf.append((new StringBuilder("\t\t<div id='")).append(chartId)
				.append("Div' align='center'>\n").toString());
		strBuf.append("\t\t\t\tChart.\n");
		strBuf.append("\t\t</div>\n");
		strBuf.append("\t\t<script type='text/javascript'>\n");
		Boolean registerWithJSBool = new Boolean(registerWithJS);
		Boolean debugModeBool = new Boolean(debugMode);
		int regWithJSInt = boolToNum(registerWithJSBool);
		int debugModeInt = boolToNum(debugModeBool);
		strBuf.append((new StringBuilder("\t\t\t\tvar chart_")).append(chartId)
				.append(" = new FusionCharts('").append(chartSWF)
				.append("', '").append(chartId).append("', '").append(
						chartWidth).append("', '").append(chartHeight).append(
						"', '").append(debugModeInt).append("', '").append(
						regWithJSInt).append("');\n").toString());
		if (strXML.equals("")) {
			strBuf.append("\t\t\t\t// Set the dataURL of the chart\n");
			strBuf.append((new StringBuilder("\t\t\t\tchart_")).append(chartId)
					.append(".setDataURL(\"").append(strURL).append("\");\n")
					.toString());
		} else {
			strBuf
					.append("\t\t\t\t// Provide entire XML data using dataXML method\n");
			strBuf.append((new StringBuilder("\t\t\t\tchart_")).append(chartId)
					.append(".setDataXML(\"").append(strXML).append("\");\n")
					.toString());
		}
		strBuf.append("\t\t\t\t// Finally, render the chart.\n");
		strBuf.append((new StringBuilder("\t\t\t\tchart_")).append(chartId)
				.append(".render(\"").append(chartId).append("Div\");\n")
				.toString());
		strBuf.append("\t\t</script>\n");
		strBuf.append("\t\t<!--END Script Block for Chart-->\n");
		return strBuf.substring(0);
	}

	public static String createChartHTML(String chartSWF, String strURL,
			String strXML, String chartId, int chartWidth, int chartHeight,
			boolean debugMode) {
		String strFlashVars = "";
		Boolean debugModeBool = new Boolean(debugMode);
		if (strXML.equals(""))
			strFlashVars = (new StringBuilder("chartWidth="))
					.append(chartWidth).append("&chartHeight=").append(
							chartHeight).append("&debugMode=").append(
							boolToNum(debugModeBool)).append("&dataURL=")
					.append(strURL).toString();
		else
			strFlashVars = (new StringBuilder("chartWidth="))
					.append(chartWidth).append("&chartHeight=").append(
							chartHeight).append("&debugMode=").append(
							boolToNum(debugModeBool)).append("&dataXML=")
					.append(strXML).toString();
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("\t\t<!--START Code Block for Chart-->\n");
		strBuf
				.append((new StringBuilder(
						"\t\t<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' ")
				.append("codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0' width='"))
						.append(chartWidth).append("' height='").append(
								chartHeight).append("' id='").append(chartId)
						.append("'>\n").toString());
		strBuf
				.append("\t\t\t\t<param name='allowScriptAccess' value='always' />\n");
		strBuf
				.append((new StringBuilder(
						"\t\t\t\t<param name='movie' value='"))
						.append(chartSWF).append("'/>\n").toString());
		strBuf.append((new StringBuilder(
				"\t\t\t\t<param name='FlashVars' value=\"")).append(
				strFlashVars).append("\" />\n").toString());
		strBuf.append("\t\t\t\t<param name='quality' value='high' />\n");
		strBuf
				.append((new StringBuilder("\t\t\t\t<embed src='"))
						.append(chartSWF)
						.append("' FlashVars=\"")
						.append(strFlashVars)
						.append("\" quality='high' width='")
						.append(chartWidth)
						.append("' height='")
						.append(chartHeight)
						.append("' name='")
						.append(chartId)
						.append(
								"' allowScriptAccess='always' type='application/x-shockwave-flash' pluginspage='http://www.macromedia.com/go/getflashplayer' />\n")
						.toString());
		strBuf.append("\t\t</object>\n");
		strBuf.append("\t\t<!--END Code Block for Chart-->\n");
		return strBuf.substring(0);
	}

	public static int boolToNum(Boolean bool) {
		int num = 0;
		if (bool.booleanValue())
			num = 1;
		return num;
	}
}