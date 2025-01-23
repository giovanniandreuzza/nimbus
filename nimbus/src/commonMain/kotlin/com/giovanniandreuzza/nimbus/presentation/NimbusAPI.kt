package com.giovanniandreuzza.nimbus.presentation

import com.giovanniandreuzza.nimbus.core.application.dtos.DownloadRequest
import com.giovanniandreuzza.nimbus.core.application.dtos.DownloadState
import kotlinx.coroutines.flow.Flow

/**
 * This is the main interface of the Nimbus library.
 *
 * @author Giovanni Andreuzza
 */
public interface NimbusAPI {

    /**
     * Get the file size.
     *
     * @param filePath The file path.
     * @return The file size.
     */
    public suspend fun getFileSize(filePath: String): Long

    /**
     * Download a file.
     *
     * @param downloadRequest The download request.
     * @return The download id.
     */
    public suspend fun downloadFile(downloadRequest: DownloadRequest): Long

    /**
     * Observe the download state.
     *
     * @param downloadId The download id.
     * @return The download state flow.
     */
    public fun observeDownload(downloadId: Long): Flow<DownloadState>

    /**
     * Pause the download.
     *
     * @param downloadId The download id.
     */
    public fun pauseDownload(downloadId: Long)

    /**
     * Resume the download.
     *
     * @param downloadId The download id.
     */
    public fun resumeDownload(downloadId: Long)

    /**
     * Cancel the download.
     *
     * @param downloadId The download id.
     */
    public fun cancelDownload(downloadId: Long)
}