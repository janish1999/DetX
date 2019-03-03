package com.example.user.defectdetector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class cameraActivity extends AppCompatActivity {
    int flag=0;
    Camera camera;
    FrameLayout frameLayout;
    ShowCamera showCamera;
    Uri result;
    ImageView imageView,click,upload,record,clear,stop,icon;
    VideoView videoView;
    MediaRecorder mediaRecorder;
    private Bitmap image;
    private Context context;
    private boolean isRecording;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private boolean isLongPress;
    Camera.Parameters params;


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        isRecording=false;
        frameLayout=(FrameLayout)findViewById(R.id.frame);
        stop=(ImageView)findViewById(R.id.stop);
        clear=(ImageView) findViewById(R.id.clear);
        click=(ImageView) findViewById(R.id.click);
        upload=(ImageView) findViewById(R.id.upload);
        record=(ImageView) findViewById(R.id.record);
        click.setVisibility(View.INVISIBLE);
        upload.setVisibility(View.INVISIBLE);
        record.setVisibility(View.INVISIBLE);
        clear.setVisibility(View.INVISIBLE);
        imageView=(ImageView)findViewById(R.id.imageView);
        icon=(ImageView)findViewById(R.id.icon);
        videoView=(VideoView)findViewById(R.id.videoView);
        imageView.setVisibility(View.INVISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);
        context=this;
        if (camera != null) {
            camera.release();
            camera = null;
        }
        try{
        params=camera.getParameters();}
        catch (NullPointerException e){
            e.printStackTrace();
        }
        camera=Camera.open();
        showCamera = new ShowCamera(this,camera);
        frameLayout.addView(showCamera);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon.setEnabled(false);
                if(flag==0){
                final Animation in = new AlphaAnimation(0.0f, 1.0f);
                in.setDuration(100);
                click.startAnimation(in);
                click.setVisibility(View.VISIBLE);
                    new CountDownTimer(240,10){

                        @Override
                        public void onFinish() {
                            final Animation in3 = new AlphaAnimation(0.0f, 1.0f);
                            in3.setDuration(100);
                            upload.startAnimation(in3);
                            upload.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onTick(long millisUntilFinished) {


                        }
                    }.start();
                    new CountDownTimer(80,10){

                        @Override
                        public void onFinish() {
                            final Animation in1 = new AlphaAnimation(0.0f, 1.0f);
                            in1.setDuration(100);
                            clear.startAnimation(in1);
                            clear.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onTick(long millisUntilFinished) {


                        }
                    }.start();
                    new CountDownTimer(160,10){

                        @Override
                        public void onFinish() {
                            final Animation in2 = new AlphaAnimation(0.0f, 1.0f);
                            in2.setDuration(100);
                            record.startAnimation(in2);
                            record.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onTick(long millisUntilFinished) {


                        }
                    }.start();
                    new CountDownTimer(240,10){

                        @Override
                        public void onFinish() {
                            final Animation in3 = new AlphaAnimation(0.0f, 1.0f);
                            in3.setDuration(100);
                            upload.startAnimation(in3);
                            upload.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onTick(long millisUntilFinished) {


                        }
                    }.start();
                    new CountDownTimer(250,10){

                        @Override
                        public void onFinish() {
                            icon.setEnabled(true);
                        }

                        @Override
                        public void onTick(long millisUntilFinished) {


                        }
                    }.start();
                flag=1;}
                else{
                    icon.setEnabled(false);
                    final Animation in = new AlphaAnimation(1.0f, 0.0f);
                    in.setDuration(100);
                    upload.startAnimation(in);
                    upload.setVisibility(View.INVISIBLE);
                    new CountDownTimer(80,10){

                        @Override
                        public void onFinish() {
                            final Animation in3 = new AlphaAnimation(1.0f, 0.0f);
                            in3.setDuration(100);
                            record.startAnimation(in3);
                            record.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onTick(long millisUntilFinished) {


                        }
                    }.start();
                    new CountDownTimer(160,10){

                        @Override
                        public void onFinish() {
                            final Animation in4 = new AlphaAnimation(1.0f, 0.0f);
                            in4.setDuration(100);
                            clear.startAnimation(in4);
                            clear.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onTick(long millisUntilFinished) {


                        }
                    }.start();
                    new CountDownTimer(240,10){

                        @Override
                        public void onFinish() {
                            final Animation in5 = new AlphaAnimation(1.0f, 0.0f);
                            in5.setDuration(100);
                            click.startAnimation(in5);
                            click.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onTick(long millisUntilFinished) {


                        }
                    }.start();
                    new CountDownTimer(250,10){

                        @Override
                        public void onFinish() {
                            icon.setEnabled(true);
                        }

                        @Override
                        public void onTick(long millisUntilFinished) {


                        }
                    }.start();
                    flag=0;

                }
            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRecording) {
                    mediaRecorder.stop();
                    releaseMediaRecorder();
                    camera.lock();
                    releaseCamera();
                    isRecording = false;
                    stop.setVisibility(View.INVISIBLE);
                    record.setVisibility(View.VISIBLE);
                } else {
                    if (prepareVideoRecorder()) {
                        mediaRecorder.start();
                        Toast.makeText(context,"Video Recording",Toast.LENGTH_SHORT).show();
                        isRecording = true;
                        record.setVisibility(View.INVISIBLE);
                        stop.setVisibility(View.VISIBLE);

                    } else {
                        releaseMediaRecorder();
                    }
                }
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Animation RotateClk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clock);
                //upload.startAnimation(RotateClk);
               // Intent intent= new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //intent.setType("*/*");//image/* video/*
                //startActivityForResult(intent, 101);// android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI
                //click.setEnabled(false);
            }
        });
        stop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isRecording) {
                            mediaRecorder.stop();
                            releaseMediaRecorder();
                            camera.lock();
                            releaseCamera();
                            isRecording = false;
                            stop.setVisibility(View.INVISIBLE);
                            record.setVisibility(View.VISIBLE);
                        } else {
                            if (prepareVideoRecorder()) {
                                mediaRecorder.start();
                                Toast.makeText(context,"Video Recording",Toast.LENGTH_SHORT).show();
                                isRecording = true;
                                record.setVisibility(View.INVISIBLE);
                                stop.setVisibility(View.VISIBLE);

                            } else {
                                releaseMediaRecorder();
                            }
                        }
                    }
                }
        );
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.INVISIBLE);
                camera=Camera.open();
                showCamera = new ShowCamera(context,camera);
                frameLayout.addView(showCamera);
                click.setEnabled(true);
            }
        });
       /* click.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(isLongPress==true) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        stopRecording();
                        Toast.makeText(context,"Action Up",Toast.LENGTH_SHORT).show();
                    }
                    isLongPress = false;
                }
                return false;
            }
        });*/
    }

    Camera.PictureCallback mpicturecallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            File file =getOutputMediaFile( MEDIA_TYPE_IMAGE);
            if (file==null){
                return;
            }else {
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(data);
                    fos.close();
                    camera.startPreview();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    };

  /*  private File getOutputMediaFile() {
        String state= Environment.getExternalStorageState();
        if(!state.equals(Environment.MEDIA_MOUNTED))
            return null;
        else{
            File folder_gui = new File(Environment.getExternalStorageDirectory()+File.separator+"GUI");
            if (!folder_gui.exists())
                folder_gui.mkdirs();
            File output_file=new File(folder_gui,"temp.jpg");
            return output_file;
        }
    }*/


    public void Capture(View v){
        if(camera!=null){
            //image = ScreenshotUtils.getScreenShot(frameLayout);
            camera.takePicture(null,null,mpicturecallback);
           // File saveFile = ScreenshotUtils.getMainDirectoryName(this);
            //File file = ScreenshotUtils.store(image, "screenshot" + screenshotType + ".jpg", saveFile);
            }
    }
    public void stopRecording(){
        mediaRecorder.stop();
        releaseMediaRecorder();
        camera.lock();
        releaseCamera();
        isRecording = false;
        stop.setVisibility(View.INVISIBLE);
        record.setVisibility(View.VISIBLE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {

            result = data.getData();
            try{
            if (result.toString().contains("image") && result != null) {
                Toast.makeText(this,"Image Was Selected",Toast.LENGTH_SHORT).show();
                imageView.setImageURI(result);
                imageView.setVisibility(View.VISIBLE);
            } else  if (result.toString().contains("video") && result != null) {
                Toast.makeText(this,"Video Was Selected",Toast.LENGTH_SHORT).show();
                videoView.setVisibility(View.VISIBLE);
                videoView.setVideoURI(result);
                videoView.requestFocus();
                videoView.start();
            }}catch (NullPointerException e){
                e.printStackTrace();
            }
               // Toast.makeText(this,"Image Selected",Toast.LENGTH_SHORT).show();
                //listener != null &&
                //listener.onFinishEditDialog(image.toString());
               // this.dismiss();

        }}

    private boolean prepareVideoRecorder(){

        camera=Camera.open();
        Camera.Parameters params=camera.getParameters();
        setOrientation(params);
       // showCamera = new ShowCamera(context,camera);
       // frameLayout.addView(showCamera);
        mediaRecorder = new MediaRecorder();

        camera.unlock();
        mediaRecorder.setCamera(camera);
        // /mediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        //mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        //mediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
        mediaRecorder.setOutputFile(getOutputMediaFile(2).toString());

        mediaRecorder.setPreviewDisplay(showCamera.getHolder().getSurface());

        try {
            mediaRecorder.prepare();
        } catch (IllegalStateException e) {
            Log.d("error", "IllegalStateException preparing MediaRecorder: " + e.getMessage());
            releaseMediaRecorder();
            return false;
        } catch (IOException e) {
            Log.d("ERROR", "IOException preparing MediaRecorder: " + e.getMessage());
            releaseMediaRecorder();
            return false;
        }
        return true;
    }


    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaRecorder();       // if you are using MediaRecorder, release it first
        releaseCamera();              // release the camera immediately on pause event
    }

    private void releaseMediaRecorder(){
        if (mediaRecorder != null) {
            mediaRecorder.reset();   // clear recorder configuration
            mediaRecorder.release(); // release the recorder object
            mediaRecorder = null;
            camera.lock();           // lock camera for later use
        }
    }

    private void releaseCamera(){
        if (camera != null){
            camera.stopPreview();
            camera.release();        // release the camera for other applications
            camera = null;
            camera=Camera.open();
            showCamera = new ShowCamera(context,camera);
            frameLayout.addView(showCamera);
            //camera.startPreview();
        }
    }





    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }


    private static File getOutputMediaFile(int type){

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");

        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == 1){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else if(type == 2) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }
    private void setOrientation(Camera.Parameters params){
        if (this.getResources().getConfiguration().orientation!= Configuration.ORIENTATION_LANDSCAPE){
            params.set("orientation","portrait");
            camera.setDisplayOrientation(90);
            params.setRotation(90);
        }else {
            params.set("orientation","landscape");
            camera.setDisplayOrientation(0);
            params.setRotation(0);
        }
        camera.setParameters(params);
    }
}
// upload.animate().rotation(upload.getRotation()-360).start();
