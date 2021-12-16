package Excepciones;

import androidx.annotation.Nullable;

import com.example.gonzalez_marrcos_examen1tadultos.R;

public class EmailInvalido extends RuntimeException {

    @Nullable
    @Override
    public String getMessage() {
        return R.string.emailInvalido
    }
}
