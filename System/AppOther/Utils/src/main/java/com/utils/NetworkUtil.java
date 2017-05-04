package com.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import com.yline.log.LogFileUtil;

/**
 * 网络状态
 *
 * @author yline 2017/5/4 -- 23:46
 * @version 1.0.0
 */
public class NetworkUtil
{
	/**
	 * 判断网络类型(同时也依据这个判断是否可用)
	 * <uses-permission Android:name="android.permission.ACCESS_NETWORK_STATE"
	 *
	 * @param context
	 * @return
	 */
	public static NetType getNetType(Context context)
	{
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (null == connectivityManager)
		{
			return NetType.None;
		}

		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if (null == networkInfo)
		{
			return NetType.None;
		}

		int type = networkInfo.getType();
		if (type == ConnectivityManager.TYPE_WIFI)
		{
			return NetType.Wifi;
		}
		else if (type == ConnectivityManager.TYPE_MOBILE)
		{
			TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			if (null == telephonyManager)
			{
				return NetType.None;
			}

			int mobileType = telephonyManager.getNetworkType();
			LogFileUtil.v("mobileType = " + mobileType);
			switch (mobileType)
			{
				case TelephonyManager.NETWORK_TYPE_GPRS:
				case TelephonyManager.NETWORK_TYPE_GSM:
				case TelephonyManager.NETWORK_TYPE_EDGE:
				case TelephonyManager.NETWORK_TYPE_CDMA:
				case TelephonyManager.NETWORK_TYPE_1xRTT:
				case TelephonyManager.NETWORK_TYPE_IDEN:
					return NetType.G2;
				case TelephonyManager.NETWORK_TYPE_UMTS:
				case TelephonyManager.NETWORK_TYPE_EVDO_0:
				case TelephonyManager.NETWORK_TYPE_EVDO_A:
				case TelephonyManager.NETWORK_TYPE_HSDPA:
				case TelephonyManager.NETWORK_TYPE_HSUPA:
				case TelephonyManager.NETWORK_TYPE_HSPA:
				case TelephonyManager.NETWORK_TYPE_EVDO_B:
				case TelephonyManager.NETWORK_TYPE_EHRPD:
				case TelephonyManager.NETWORK_TYPE_HSPAP:
				case TelephonyManager.NETWORK_TYPE_TD_SCDMA:
				case TelephonyManager.NETWORK_TYPE_IWLAN: // 和源码不一样,但是华为P7测试结果为3G
					return NetType.G3;
				case TelephonyManager.NETWORK_TYPE_LTE:
				case 19: // TelephonyManager.NETWORK_TYPE_LTE_CA:
					return NetType.G4;
				default:
					return NetType.None;
			}
		}
		return NetType.None;
	}

	public enum NetType
	{
		None, Wifi, G2, G3, G4;
	}
}
