package android.com.socialmediaapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

// Add this to the header of your file:

//paso a paso https://www.codeofaninja.com/2013/02/android-share-intent-example.html
public class MainActivity extends AppCompatActivity {

    private int PICK_IMAGE_REQUEST = 1;
    String imgDecodableString;
    ImageView imgView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // botones sociales
        ImageButton shareTwitter = (ImageButton) findViewById(R.id.shareTw);
        shareTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para compartir
                Intent share = new Intent(Intent.ACTION_SEND);
                // indicar el tipo de imagen que se va a compartir
                share.setType("image/*");
                // obtener el path de la imagen seleccionada (luego de haberla elegido en la galeria en el paso anterior btnGetImage)
                File imageFileToShare = new File(imgDecodableString);
                Uri uri = Uri.fromFile(imageFileToShare);
                share.putExtra(Intent.EXTRA_STREAM, uri);
                share.setPackage("com.twitter.android");
                startActivity(Intent.createChooser(share, "Compartir imagen en Twitter"));
            }
        });
        ImageButton shareFacebook = (ImageButton) findViewById(R.id.shareFace);
        shareFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para compartir
                Intent share = new Intent(Intent.ACTION_SEND);
                // indicar el tipo de imagen que se va a compartir
                share.setType("image/*");
                // obtener el path de la imagen seleccionada (luego de haberla elegido en la galeria en el paso anterior btnGetImage)
                File imageFileToShare = new File(imgDecodableString);
                Uri uri = Uri.fromFile(imageFileToShare);
                share.putExtra(Intent.EXTRA_STREAM, uri);
                share.setPackage("com.facebook.katana");
                startActivity(Intent.createChooser(share, "Compartir imagen en Facebook"));
            }
        });
        ImageButton shareInstagram = (ImageButton) findViewById(R.id.shareInst);
        shareInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para compartir
                Intent share = new Intent(Intent.ACTION_SEND);
                // indicar el tipo de imagen que se va a compartir
                share.setType("image/*");
                // obtener el path de la imagen seleccionada (luego de haberla elegido en la galeria en el paso anterior btnGetImage)
                File imageFileToShare = new File(imgDecodableString);
                Uri uri = Uri.fromFile(imageFileToShare);
                share.putExtra(Intent.EXTRA_STREAM, uri);
                share.setPackage("com.instagram.android");
                startActivity(Intent.createChooser(share, "Compartir imagen en Instagram"));
            }
        });
        ImageButton shareWhatsapp = (ImageButton) findViewById(R.id.shareWap);
        shareWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para compartir
                Intent share = new Intent(Intent.ACTION_SEND);
                // indicar el tipo de imagen que se va a compartir
                share.setType("image/*");
                // obtener el path de la imagen seleccionada (luego de haberla elegido en la galeria en el paso anterior btnGetImage)
                File imageFileToShare = new File(imgDecodableString);
                Uri uri = Uri.fromFile(imageFileToShare);
                share.putExtra(Intent.EXTRA_STREAM, uri);
                share.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(share, "Compartir imagen en WhatsApp"));
            }
        });
        ImageButton shareLinkedin = (ImageButton) findViewById(R.id.shareLinked);
        shareLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para compartir
                Intent share = new Intent(Intent.ACTION_SEND);
                // indicar el tipo de imagen que se va a compartir
                share.setType("image/*");
                // obtener el path de la imagen seleccionada (luego de haberla elegido en la galeria en el paso anterior btnGetImage)
                File imageFileToShare = new File(imgDecodableString);
                Uri uri = Uri.fromFile(imageFileToShare);
                share.putExtra(Intent.EXTRA_STREAM, uri);
                share.setPackage("com.linkedin.android");
                startActivity(Intent.createChooser(share, "Compartir imagen en LinkedIn"));
            }
        });

        // View para la imagen
        imgView = (ImageView) findViewById(R.id.imageView);

        //texto para compartir
        final EditText editText = (EditText) findViewById(R.id.editText);

        //compartir Texto
        Button btnText = (Button) findViewById(R.id.btnText);
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Título");
                share.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
                startActivity(Intent.createChooser(share, "Compartir texto"));
            }
        });

        //obtener Imagen
        Button btnGetImage = (Button) findViewById(R.id.btnGetImage);
        btnGetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent para abrir la galería y seleccionar la imagen
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);//
                startActivityForResult(Intent.createChooser(intent, "Select File"),PICK_IMAGE_REQUEST);

            }
        });

        //compartir Imagen
        Button btnShareImage = (Button) findViewById(R.id.btnImage);
        btnShareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent para compartir
                Intent share = new Intent(Intent.ACTION_SEND);
                // indicar el tipo de imagen que se va a compartir
                share.setType("image/*");
                // obtener el path de la imagen seleccionada (luego de haberla elegido en la galeria en el paso anterior btnGetImage)
                File imageFileToShare = new File(imgDecodableString);
                Uri uri = Uri.fromFile(imageFileToShare);
                share.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(share, "Compartir imagen"));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
                onSelectFromGalleryResult(data);
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(selectedImage,
        filePathColumn, null, null, null);
        // Posicionar el cursor
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        //asignar path de la imagen seleccionada
        imgDecodableString = cursor.getString(columnIndex);
        //setear imagen al image view
        imgView.setImageBitmap(bm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}