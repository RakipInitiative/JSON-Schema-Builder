package de.bund.bfr.kidaeditorbackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.bund.bfr.kidaeditorbackend.dto.SchemaIdDto;
import de.bund.bfr.kidaeditorbackend.dto.SchemaMetaDataResponseDto;
import de.bund.bfr.kidaeditorbackend.dto.SchemaUpdateDto;
import de.bund.bfr.kidaeditorbackend.service.ModelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class EditorControllerTest {

    @InjectMocks
    private EditorController editorController;

    @Mock
    private ModelService modelService;

    private MockMvc mockMvc;

    @BeforeEach
    private void setupTest() {
        mockMvc = MockMvcBuilders.standaloneSetup(editorController).build();
    }

    /**
     * Tests if the service method is called
     *
     * @throws Exception
     */
    @Test
    public void testAllModels() throws Exception {
        when(modelService.getAllModels()).thenReturn(List.of(SchemaMetaDataResponseDto.builder().build()));

        mockMvc.perform(get("/kidaBackend/allModels")).andExpect(status().is2xxSuccessful());
    }

    /**
     * Tests if the getModel service method is called
     *
     * @throws Exception
     */
    @Test
    public void testGetModel() throws Exception {
        when(modelService.getModel(anyString())).thenReturn("{}");

        String requestBody = "{\"id\":\"myId\"}";

        mockMvc.perform(post("/kidaBackend/getModel")
                        .content(requestBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Tests if the saveModel service method is called
     *
     * @throws Exception
     */
    @Test
    public void testSaveModel() throws Exception {
        SchemaUpdateDto requestBody = SchemaUpdateDto.builder().id("myID").updatedSchema("{}").build();
        mockMvc.perform(put("/kidaBackend/saveModel")
                        .content(writeAsJsonString(requestBody)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    private String writeAsJsonString(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void testDownload() throws Exception {
        SchemaIdDto requestBody = SchemaIdDto.builder().id("myID").build();
        mockMvc.perform(post("/kidaBackend/download")
                        .content(writeAsJsonString(requestBody)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}
