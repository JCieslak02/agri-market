package com.jcieslak.agrimarket.service;

import com.jcieslak.agrimarket.model.Image;
import com.jcieslak.agrimarket.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Image createAndSaveThumbnail(Image image) throws IOException {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(image.getImageData()));
        BufferedImage thumbnailImage = new BufferedImage(500, 300, BufferedImage.TYPE_INT_RGB);
        thumbnailImage.createGraphics().drawImage(originalImage.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH), 0, 0, null);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(thumbnailImage, "jpg", outputStream);

        byte[] resizedImageData = outputStream.toByteArray();

        image.setImageData(resizedImageData);
        return imageRepository.save(image);
    }
}
