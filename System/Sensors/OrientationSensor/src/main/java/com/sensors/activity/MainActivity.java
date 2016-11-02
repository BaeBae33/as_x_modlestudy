package com.sensors.activity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sensors.R;
import com.sensors.SensorHelper;
import com.yline.base.BaseAppCompatActivity;
import com.yline.log.LogFileUtil;

public class MainActivity extends BaseAppCompatActivity
{
	private SensorManager sensorManager;

	private SensorListener sensorListener;

	private SensorHelper sensorHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sensorHelper = new SensorHelper(MainActivity.this);

		// 指南针,老的方式
		final TextView tvOrientation = (TextView) findViewById(R.id.tv_orientation);
		findViewById(R.id.btn_orientation).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				LogFileUtil.v("tv_orientation");
				sensorHelper.registerOrientationListener(new SensorEventListener()
				{
					@Override
					public void onSensorChanged(SensorEvent event)
					{
						float afterAngle = sensorHelper.dealWithOrientation(event);
						tvOrientation.setText("afterAngle : " + afterAngle);
					}

					@Override // 当传感器的精度发生变化时就会调用
					public void onAccuracyChanged(Sensor sensor, int accuracy)
					{

					}
				});
			}
		});
		
		// 地磁传感器
		final TextView tvMagnetic = (TextView) findViewById(R.id.tv_magnetic);
		findViewById(R.id.btn_magnetic).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				LogFileUtil.v("btn_magnetic");
				sensorHelper.registerMagneticListener(new SensorEventListener()
				{

					@Override
					public void onSensorChanged(SensorEvent event)
					{
						double afterAngle = sensorHelper.dealWithMagnetic(event);
						tvMagnetic.setText("afterAngle : " + afterAngle);
					}

					@Override // 当传感器的精度发生变化时就会调用
					public void onAccuracyChanged(Sensor sensor, int accuracy)
					{

					}
				});
			}
		});

		// 加速度传感器
		final TextView tvAccelerometer = (TextView) findViewById(R.id.tv_accelerometer);
		findViewById(R.id.btn_accelerometer).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(final View v)
			{
				LogFileUtil.v("btn_accelerometer");
				sensorHelper.registerAccelerometerListener(new SensorEventListener()
				{
					@Override
					public void onSensorChanged(SensorEvent event)
					{
						float value = sensorHelper.dealWithAccelerometer(event);
						tvAccelerometer.setText("value = " + value);
					}

					@Override
					public void onAccuracyChanged(Sensor sensor, int accuracy)
					{

					}
				});
			}
		});

		// 光传感器
		final TextView tvLight = (TextView) findViewById(R.id.tv_light);
		findViewById(R.id.btn_light).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				LogFileUtil.v("btn_light");
				sensorHelper.registerLightListener(new SensorEventListener()
				{
					@Override
					public void onSensorChanged(SensorEvent event)
					{
						float value = sensorHelper.dealWithLight(event);
						tvLight.setText("value = " + value);
					}

					@Override
					public void onAccuracyChanged(Sensor sensor, int accuracy)
					{

					}
				});
			}
		});
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		sensorHelper.unRegisterListener();
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}
}
