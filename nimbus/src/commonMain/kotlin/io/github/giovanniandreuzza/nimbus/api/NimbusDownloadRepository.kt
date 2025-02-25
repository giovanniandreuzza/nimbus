package io.github.giovanniandreuzza.nimbus.api

import io.github.giovanniandreuzza.explicitarchitecture.shared.KResult
import io.github.giovanniandreuzza.nimbus.core.application.dtos.DownloadStream
import io.github.giovanniandreuzza.nimbus.core.domain.errors.StartDownloadErrors
import io.github.giovanniandreuzza.nimbus.core.errors.GetFileSizeFailed

/**
 * Nimbus Download Repository.
 *
 * @author Giovanni Andreuzza
 */
public interface NimbusDownloadRepository {

    /**
     * Get the file size.
     *
     * @param fileUrl The file URL.
     * @return The file size.
     */
    public suspend fun getFileSize(fileUrl: String): KResult<Long, GetFileSizeFailed>

    /**
     * Download a file.
     *
     * @param fileUrl The file URL.
     * @param offset The offset.
     * @return The download stream.
     */
    public suspend fun downloadFile(
        fileUrl: String,
        offset: Long?
    ): KResult<DownloadStream, StartDownloadErrors.StartDownloadFailed>
}