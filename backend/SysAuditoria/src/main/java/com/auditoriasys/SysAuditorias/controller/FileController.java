package com.auditoriasys.SysAuditorias.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.auditoriasys.SysAuditorias.entities.Documento;
import com.auditoriasys.SysAuditorias.entities.Ejemplo;
import com.auditoriasys.SysAuditorias.entities.Imagen;
import com.auditoriasys.SysAuditorias.services.DocumentoService;
import com.auditoriasys.SysAuditorias.services.EjemploService;
import com.auditoriasys.SysAuditorias.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/file")
public class FileController {

    @Autowired
    private ImagenService imagenService;

    @Autowired
    private EjemploService ejemploService;

    @Autowired
    private DocumentoService documentoService;

    private final String directorio_files = "src/main/resources/files/";
    private final String directorio_imgs = "src/main/resources/img/";

    //Metodo para subir archivos de momento trabaja aqui pero se creara su respectivo service ps para tener
    //mas orden

    @PostMapping("/subirDocumento/{codigo_sub_item}")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file, @PathVariable Integer codigo_sub_item) {
        try {
            File d1 = new File(directorio_files);
            if (!d1.exists()) d1.mkdirs();

            String nombre_archivo = file.getOriginalFilename();
            String fileExtension = nombre_archivo.substring(nombre_archivo.lastIndexOf(".")).toLowerCase();

            Path filePath = Paths.get(directorio_files + file.getOriginalFilename());

            if (fileExtension.equals(".pdf")) {
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                documentoService.createDocumento(new Documento(0, nombre_archivo, codigo_sub_item));
                return ResponseEntity.ok("Archivo PDF subido con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato de archivo no soportado");
            }


        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    @PostMapping("/subirEjemplo/{codigo_sub_item}")
    public ResponseEntity<String> uploadEjemplo(@RequestParam MultipartFile file, @PathVariable Integer codigo_sub_item) {
        try {
            File d1 = new File(directorio_files);
            if (!d1.exists()) d1.mkdirs();

            String nombre_archivo = file.getOriginalFilename();
            String fileExtension = nombre_archivo.substring(nombre_archivo.lastIndexOf(".")).toLowerCase();

            Path filePath = Paths.get(directorio_files + file.getOriginalFilename());

            if (fileExtension.equals(".pdf")) {
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                ejemploService.createEjemplo(new Ejemplo(0,nombre_archivo,codigo_sub_item));
                return ResponseEntity.ok("Archivo PDF subido con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato de archivo no soportado");
            }


        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }


    @DeleteMapping("/eliminarDocumento/{codigoDocumento}")
    public ResponseEntity<String> deleteDocumento(@PathVariable Integer codigoDocumento) {
        try {

            Optional<Documento> doc = documentoService.findDocumentoById(codigoDocumento);
            Documento doqui = doc.get();
            Path filePath = Paths.get(directorio_files + doqui.getNombreDocumento());

            Files.delete(filePath);
            documentoService.deleteDocumento(codigoDocumento);
            return ResponseEntity.ok("Archivo eliminado correctamente");

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    @DeleteMapping("/eliminarEjemplo/{codigoEjemplo}")
    public ResponseEntity<String> deleteEjemplo(@PathVariable Integer codigoEjemplo) {
        try {

            Optional<Ejemplo> doc = ejemploService.findEjemploById(codigoEjemplo);
            Ejemplo doqui = doc.get();
            Path filePath = Paths.get(directorio_files + doqui.getNombreEjemplo());

            Files.delete(filePath);
            ejemploService.deleteEjemplo(codigoEjemplo);

            return ResponseEntity.ok("Archivo eliminado correctamente");

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    @DeleteMapping("/eliminarImg/{codigoImg}")
    public ResponseEntity<String> deleteImg(@PathVariable Integer codigoImg) {
        try {

            Optional<Imagen> doc = imagenService.findImagenById(codigoImg);
            Imagen imagi = doc.get();
            Path filePath = Paths.get(directorio_imgs + imagi.getNombreImagen());

            Files.delete(filePath);

            imagenService.deleteImagen(codigoImg);
            return ResponseEntity.ok("Archivo eliminado correctamente");

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }

    //Esto sube una imagen que se relacion segun el codigo de la norma que pasamos por el url
    @PostMapping("/subirImg/{codigo_norma}")
    public ResponseEntity<String> uploadImage(@RequestParam MultipartFile img,@RequestParam String descripcion,
                                              @PathVariable Integer codigo_norma) {

        try {
            File d2 = new File(directorio_imgs);;
            if(!d2.exists()) d2.mkdirs();

            String nombre_archivo = img.getOriginalFilename();
            String fileExtension = nombre_archivo.substring(nombre_archivo.lastIndexOf(".")).toLowerCase();

            Path imgPath = Paths.get(directorio_imgs + img.getOriginalFilename());

            if (fileExtension.equals(".png") || fileExtension.equals(".jpg") || fileExtension.equals(".jpeg")) {
                Files.copy(img.getInputStream(), imgPath, StandardCopyOption.REPLACE_EXISTING);
                imagenService.createImagen(new Imagen(0,nombre_archivo,descripcion,codigo_norma));
                return ResponseEntity.ok("Imagen subido con éxito");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato de archivo no soportado");
            }


        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo");
        }
    }


    //este es el de descargar y tmb lo mimso de arriba ya se creara su service y de ser necesario un repository
    @GetMapping("/obtener/{nombre_archivo}")
    public ResponseEntity<Resource> descargarFile(@PathVariable String nombre_archivo) {

        String fileExtension = nombre_archivo.substring(nombre_archivo.lastIndexOf(".")).toLowerCase();
        Path filePath = (fileExtension.equals(".pdf")) ? Paths.get(directorio_files + nombre_archivo)
                : Paths.get(directorio_imgs + nombre_archivo);

        MediaType tipoArchivo = null;

        switch (fileExtension) {
            case ".pdf" -> tipoArchivo = MediaType.APPLICATION_PDF;
            case ".png" -> tipoArchivo = MediaType.IMAGE_PNG;
            case ".jpeg" -> tipoArchivo = MediaType.IMAGE_JPEG;
            case ".jpg" -> tipoArchivo = MediaType.IMAGE_JPEG;
        }

        try {
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(tipoArchivo)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + nombre_archivo + "\"")
                        .body(resource);
            }
            else return ResponseEntity.status(404).body(null);

        } catch (MalformedURLException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    //Este metodo devuelve todos los links de las imagenes de acuerdo a la nomra iso mandada en el url
    @GetMapping("/obtenerImagenes/{codigoIso}")
    public ResponseEntity<List<String>> obtenerImagenesIso(@PathVariable Integer codigoIso) {
        List<Imagen> listaImagenes = buscarImgByCodigoNorma(codigoIso);
        List<String> listaUrls = new ArrayList<>();

        for (Imagen imagen : listaImagenes) {
            String nombreImagen = imagen.getNombreImagen();
            String urlImagen = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/file/obtener/")
                    .path(nombreImagen)
                    .toUriString();
            listaUrls.add(urlImagen);  // Añadir URL del endpoint para servir la imagen
        }

        if (listaUrls.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }

        return ResponseEntity.ok(listaUrls); // Devuelve la lista de URLs en el body
    }

    @GetMapping("/documentos")
    public List<Documento> listarDocumentos() {
        return documentoService.getDocumentos();
    }

    @GetMapping("/ejemplos")
    public List<Ejemplo> listarEjemplos() {
        return ejemploService.getEjemplos();
    }

    @GetMapping("/imagenes")
    public List<Imagen> listarImagenes() {
        return imagenService.getImagen();
    }

    @GetMapping("/buscarImgs/{codigo_norma}")
    public List<Imagen> buscarImgByCodigoNorma(@PathVariable Integer codigo_norma) {
        return imagenService.findByCodigoNormaIso(codigo_norma);
    }

    @GetMapping("/buscarEjemplos/{codigo_subItem}")
    public List<Ejemplo> buscarEjemploByCodigoSubItem(@PathVariable Integer codigo_subItem) {
        return ejemploService.findByCodigoSubItem(codigo_subItem);
    }

    @GetMapping("/buscarDocumentos/{codigo_subItem}")
    public List<Documento> buscarDocumentoByCodigoSubItem(@PathVariable Integer codigo_subItem) {
        return documentoService.findByCodigoSubItem(codigo_subItem);
    }
}