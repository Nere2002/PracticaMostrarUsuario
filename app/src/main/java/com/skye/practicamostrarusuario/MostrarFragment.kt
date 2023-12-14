import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.skye.practicamostrarusuario.R
import com.skye.practicamostrarusuario.databinding.FragmentMostrarBinding

class MostrarFragment : Fragment() {
    private lateinit var binding: FragmentMostrarBinding
    //private lateinit var textViewMensajeError: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMostrarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtén los argumentos del Bundle
        val username = arguments?.getString("username")
        val password = arguments?.getString("password")

        // Muestra el usuario y la contraseña en los TextView correspondientes
        binding.mtUsername.text = getString(R.string.username_label, username)
        binding.mtPassword.text = getString(R.string.password_label, password)


//        binding.mtUsername.text = "Username: $username"
//        binding.mtPassword.text = "Password: $password"
    }
}
