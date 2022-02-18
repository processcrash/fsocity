package com.fsocity.framework.security.validation;

import java.awt.image.BufferedImage;

/**
 * @author zail
 * @since 2018-09-27
 */
public class ImageValidationCode extends DefaultValidationCode {
    
    // 图片
    private BufferedImage image;
    
    public ImageValidationCode(String code, int expireIn, BufferedImage image) {
        super(code, expireIn);
        this.image = image;
    }
    
    public BufferedImage getImage() {
        return image;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    @Override
    public boolean matches(String formCode) {
        if (formCode != null) {
            return formCode.equals(this.getCode());
        }
        
        return false;
    }
}
