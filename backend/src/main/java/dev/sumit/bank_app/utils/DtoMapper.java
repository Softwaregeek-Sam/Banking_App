package dev.sumit.bank_app.utils;

import dev.sumit.bank_app.dto.response.DownloadResponse;
import dev.sumit.bank_app.fileManagement.Document;

public class DtoMapper {
    public static DownloadResponse documentToDownloadResponse(Document document) {
        DownloadResponse dto = new DownloadResponse();
        dto.setDocumentId(document.getDocumentId());
        dto.setName(document.getName());
        dto.setDescription(document.getDescription());
        return dto;
    }
}
