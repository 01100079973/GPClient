package com.omarGPClient.gpclient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
EditText ip;
EditText port ;
EditText msg ;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         ip = (EditText) findViewById(R.id.eip);
         port = (EditText) findViewById(R.id.eport);
         msg = (EditText) findViewById(R.id.emsg);
         b = (Button) findViewById(R.id.button1);
           b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				   Thread t = new Thread (new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								Socket s = new Socket (ip.getText().toString(),Integer.parseInt(port.getText().toString()));
								DataOutputStream dataout = new  DataOutputStream (s.getOutputStream());
								dataout.writeUTF(msg.getText().toString());
								//Toast.makeText(getApplicationContext(),"message sent to server", 
										  // Toast.LENGTH_LONG).show();
								dataout.flush();
								dataout.close();
								//s.close();
								
							} catch (NumberFormatException e) {
								// TODO Auto-generated catch block
								Toast.makeText(getApplicationContext(),"check format", 
										   Toast.LENGTH_LONG).show();
								e.printStackTrace();
							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								Toast.makeText(getApplicationContext(),"check server", 
										   Toast.LENGTH_LONG).show();
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
			        	
			        });
				   t.start();
			}
		});
     


  
   }


   
}
